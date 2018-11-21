package src.sql.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import src.ui.admin.*;
import src.sql.controller.PasswordHasher;
import src.sql.model.*;
import src.sql.tables.Departments;
import src.sql.tables.DegreeLinks;
import src.sql.tables.Degrees;
import src.sql.tables.Modules;
import src.sql.tables.Users;

public class AdminController {

    private AdminDatabaseModel databaseModel;

    public AdminController() {
        databaseModel = new AdminDatabaseModel();
    }
    
    /**
     * Function generates a code for a table.
     * 
     * @param String baseCode - The string code that entries in a table will share
     *               e.g. "COM"
     * @param ArrayList<Object[]> table - table represented as a ArrayList of
     *               Object arrays
     * @param String numCodeLength - length of the unqiue number the code will have
     */
    private String generateUniqueCode(String baseCode, ArrayList<Object[]> table, String numCodeLength) {
        String numCode;
        int rowNum = table.size();
        if (rowNum == 0) {
            numCode = String.format("%0" + numCodeLength + "d", 0);
        } else {
            String prevNumCode = (String) table.get(rowNum - 1)[0];
            int code = Integer.parseInt(prevNumCode.substring(baseCode.length()));
            numCode = String.format("%0" + numCodeLength + "d", (code + 1));
        }
        return baseCode + numCode;
    }
    private String generateUsername(String baseUsername, ArrayList<Object[]> table) {
        int rowNum = table.size();
        if (rowNum == 0) {
            return baseUsername + "1";
        } else {
            String prevName = (String) table.get(rowNum - 1)[4];
            int prevNum = Integer.parseInt(prevName.substring(baseUsername.length()));
            return baseUsername + Integer.toString(prevNum + 1);
        }
    }
    public String[] getDepartmentNames() {
        Departments departments = databaseModel.getDepartments("*","");
        return departments.getDepartmentNames();
    }
    public String[] getDegreeNames() {
        Degrees degrees = databaseModel.getDegrees("*", "");
        return degrees.getDegreeNames();
    }
    public String getDegreeCode(String degreeName) {
        Degrees degrees = databaseModel.getDegrees("*", "WHERE `Degree name`='" + degreeName + "';");
        Object[] degreeCode = degrees.getColumn(0);
        return (String) degreeCode[0];
    }
    public String[] getModuleNames() {
        Modules modules = databaseModel.getModules("*","");
        return modules.getModuleNames();
    }
    /**
     * Method adds a department to the database.
     * @param name - Department name to be added to the database
     * @return success - Boolean indicating if Department name was already in the database
     */
    public Boolean addDepartment(String name){

        String departmentCode = name.substring(0, 3).toUpperCase();

        Departments departments = databaseModel.getDepartments("*","");
        if (departments.occursInTable(departmentCode,0)) {
            return false;
        } else {
            String values = "('" + departmentCode + "','" + name + "')";
            databaseModel.insertIntoDatabase("Department", values);
            return true;
        }        
    }
    public void addUser(String name, String surname, String password, String role) {

        byte[] salt = PasswordHasher.generateSalt();
        byte[] hashedPassword = PasswordHasher.generateHashPassword(password, salt);

        String baseUsername = (name.substring(0, 1) + surname).toLowerCase();
        Users users = databaseModel.getUsers("*","WHERE Username LIKE '" + baseUsername + "%';");
        String username = generateUsername(baseUsername, users.getTableList());

        String email = username + "@sheffield.ac.uk";
        String title = "Mr.";
        /*String values = "('" + username + "','" + hashedPassword + "','"  + role + "','" + email + "','" + 
                               name + "','" + title + "','" + surname + "','" + salt+"')";*/
        
        //databaseModel.insertIntoDatabase("Users",values);
        databaseModel.insertUsers(username, hashedPassword, role, email, name, title, surname, salt);
        
    }
    public void addDegreeLink(String departmentCode, String degreeCode) {
    
        String values = "(NULL, '" + departmentCode + "','" + degreeCode + "')";
        databaseModel.insertIntoDatabase("`Department degree (linking)`", values);
    }
    public Boolean addDegreeLink(String degreeName, String departmentCode, String degreeNamePassed) {
        
        String degreeCode = getDegreeCode(degreeName);
        DegreeLinks degreeLinks = databaseModel.getDegreeLinks("*","Degree_DegreeCode='" + degreeCode + 
                                                                   "' AND Department_DepartmentCode='" + departmentCode + "'");
        if (degreeLinks.occursInTable(degreeCode, departmentCode)) {
            return false;
        } else {
            addDegreeLink(departmentCode, degreeCode);
            return true;
        }
    }
    public Boolean addDegree(String name, String leadDepartment, String levelOfStudy) {

        Degrees degrees = databaseModel.getDegrees("*","");
        if (degrees.occursInTable(name,1)) {
            return false;
        } else {
            String departmentCode = leadDepartment.substring(0, 3).toUpperCase();
            String degreeCodeChars;
            if (levelOfStudy.charAt(0)=='1') {
                degreeCodeChars = departmentCode + "U";
            } else {
                degreeCodeChars = departmentCode + "P";
            }
            Degrees degree = databaseModel.getDegrees("*", "WHERE DegreeCode LIKE '" + degreeCodeChars + "%'");
            String degreeCode = generateUniqueCode(degreeCodeChars, degree.getTableList(), "2");
            String values = "('" + degreeCode + "','" + name +  "','" + levelOfStudy + "')";

            databaseModel.insertIntoDatabase("Degree", values);
            addDegreeLink(departmentCode, degreeCode);
            return true;
        }
    }
    public void addModule(String name, String teachingDepartment) {
        //generates new unique module code
        String departmentCode = teachingDepartment.substring(0, 3).toUpperCase();
        Modules modules = databaseModel.getModules("*", "WHERE ModuleCode LIKE '" + departmentCode + "%'");
        
        String moduleCode = generateUniqueCode(departmentCode, modules.getTableList(), "4");

        String values = "('"+ moduleCode + "','" + name + "','" + teachingDepartment + "')";
        databaseModel.insertIntoDatabase("Module", values);
    }
    public void removeModule(String moduleCode) {
        String conditions = "(ModuleCode = '" + moduleCode + "');";
        databaseModel.removeFromDatabase("Module", conditions);
    }
    public void removeDepartment(String departmentCode){
        String conditions = "(DepartmentCode = '" + departmentCode + "');";
        databaseModel.removeFromDatabase("Department",conditions);
    }
    public void removeUser(String username){
        String conditions = "(Username = '" + username + "');";
        databaseModel.removeFromDatabase("Users",conditions);
    }
    public void removeDegree(String degreeCode){
        databaseModel.removeFromDatabase("`Department degree (linking)`", "(Degree_DegreeCode='" + degreeCode + "');");
        databaseModel.removeFromDatabase("Degree","(DegreeCode = '" + degreeCode + "');");
    }
    public void removeDegreeLink(String degreeCode, String departmentCode) {
        //Degrees degree = databaseModel.getDegrees("*", "WHERE DegreeCode='" + degreeCode + "'");
        //Object degreesLeadDepartment = degree.getColumn()
        databaseModel.removeFromDatabase("`Department degree (linking)`", "Degree_DegreeCode='" + degreeCode + "' AND " + 
                                            "Department_DepartmentCode='" + departmentCode + "';");
    }
}