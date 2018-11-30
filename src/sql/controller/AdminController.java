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
import src.sql.tables.ModuleLinks;

public class AdminController {

    private AdminDatabaseModel databaseModel;
    private SQLValidation validation;

    public AdminController() {
        databaseModel = new AdminDatabaseModel();
        validation = new SQLValidation();
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
        degreeName = validation.generalValidation(degreeName);
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
  
        if (name.length() < 3)
            return false;

        name = validation.generalValidation(name);
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
        
        name = validation.generalValidation(name);
        surname = validation.generalValidation(surname);
        role = validation.generalValidation(role);
        
        byte[] salt = PasswordHasher.generateSalt();
        byte[] hashedPassword = PasswordHasher.generateHashPassword(password, salt);

        String baseUsername = (name.substring(0, 1) + surname).toLowerCase();
        Users users = databaseModel.getUsers("*","WHERE Username LIKE '" + baseUsername + "%' " +
                                                  "ORDER BY CHAR_LENGTH(Username);");
        String username = generateUsername(baseUsername, users.getTableList());

        String email = username + "@sheffield.ac.uk";
        String title = "Mr.";
        /*String values = "('" + username + "','" + hashedPassword + "','"  + role + "','" + email + "','" + 
                               name + "','" + title + "','" + surname + "','" + salt+"')";*/
        
        //databaseModel.insertIntoDatabase("Users",values);
        databaseModel.insertUsers(username, hashedPassword, role, email, name, title, surname, salt);
        
    }
    public void addDegreeLink(String departmentCode, String degreeCode) {
    
        departmentCode = validation.generalValidation(departmentCode);
        degreeCode = validation.generalValidation(degreeCode);
        
        String values = "(NULL, '" + departmentCode + "','" + degreeCode + "')";
        databaseModel.insertIntoDatabase("`Department degree (linking)`", values);
    }
    public Boolean addDegreeLink(String degreeName, String departmentCode, String degreeNamePassed) {
        
        degreeName = validation.generalValidation(degreeName);
        departmentCode = validation.generalValidation(departmentCode);
        degreeNamePassed = validation.generalValidation(degreeNamePassed);
        
        String degreeCode = getDegreeCode(degreeName);
        DegreeLinks degreeLinks = databaseModel.getDegreeLinks("*","dll.Degree_DegreeCode='" + degreeCode + 
                                                                   "' AND dll.Department_DepartmentCode='" + departmentCode + "'");
        if (degreeLinks.getNumOfRows() != 0)
            return false;
            
        addDegreeLink(departmentCode, degreeCode);
        return true;
    }
    public Boolean addDegree(String name, String leadDepartment, String levelOfStudy) {

        if (name.length() < 3)
            return false;

        name = validation.generalValidation(name);
        leadDepartment = validation.generalValidation(leadDepartment);
        levelOfStudy = validation.generalValidation(levelOfStudy);
        
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
            String values = "('" + degreeCode + "','" + name +  "','" + levelOfStudy + "','" + leadDepartment + "')";

            databaseModel.insertIntoDatabase("Degree", values);
            addDegreeLink(departmentCode, degreeCode);
            return true;
        }
    }
    public Boolean addModule(String name, String teachingDepartment) {
        
        name = validation.generalValidation(name);
        teachingDepartment = validation.generalValidation(teachingDepartment);
        
        String departmentCode = teachingDepartment.substring(0, 3).toUpperCase();
        Modules modules = databaseModel.getModules("*", "WHERE ModuleCode LIKE '" + departmentCode + "%'");
        //generates new unique module code
        String moduleCode = generateUniqueCode(departmentCode, modules.getTableList(), "4");

        Modules duplicateModules = databaseModel.getModules("*", "WHERE `Full name`='" + name + "'");
        if (duplicateModules.getNumOfRows() != 0)
            return false;

        String values = "('"+ moduleCode + "','" + name + "','" + teachingDepartment + "')";
        databaseModel.insertIntoDatabase("Module", values);
        return true;
    }
    public Boolean addModuleLink(String moduleCode, String degreeCode, String level, String semester, String coreOrNot, String typeOfModule) {

        ModuleLinks moduleLinks = databaseModel.getModuleLinks("*","mdl.Module_ModuleCode='" + moduleCode + 
                                                                    "' AND mdl.Degree_DegreeCode='" + degreeCode + "'");
        if (moduleLinks.getNumOfRows() != 0)
            return false;

        String credits;
        if (typeOfModule.equals("Year In Industry")) {
            credits = "120";
            coreOrNot = "Core";
        } else {
            if (level.equals("4")) {
                if (typeOfModule.equals("Dissertation"))
                    credits = "60";
                else
                    credits = "15";
            } else {
                if (typeOfModule.equals("Dissertation"))
                    credits = "40";
                else
                    credits = "20";
            }
        }   

        String values = "(NULL, '" + moduleCode + "','" + degreeCode + "','" + level + "','" + semester + "','" + credits + "','" + coreOrNot + "')";
        databaseModel.insertIntoDatabase("`Module degree (linking)`", values);
        return true;
    }
    public Boolean removeModule(String moduleCode) {
        
        moduleCode = validation.generalValidation(moduleCode);
        
        String conditions = "(ModuleCode = '" + moduleCode + "');";
        Boolean successfullyRemoved = databaseModel.executeWithBool("DELETE FROM Module WHERE " + conditions + ";");
        return successfullyRemoved;
    }
    /**
     * Method removes department via departmentCode
     * @param departmentCode - code of department to be deleted
     */
    public Boolean removeDepartment(String departmentCode){
        
        departmentCode = validation.generalValidation(departmentCode);
        
        String conditions = "(DepartmentCode = '" + departmentCode + "');";
        Boolean successfullyRemoved = databaseModel.executeWithBool("DELETE FROM Department WHERE " + conditions + ";");
        return successfullyRemoved;
    }
    public void removeUser(String username){
        
        username = validation.generalValidation(username);
        
        String conditions = "(Username = '" + username + "');";
        databaseModel.removeFromDatabase("Users",conditions);
    }
    public Boolean removeDegree(String degreeCode){
        
        degreeCode = validation.generalValidation(degreeCode);
        
        databaseModel.removeFromDatabase("`Department degree (linking)`", "(Degree_DegreeCode='" + degreeCode + "');");
        Boolean successfullyRemoved = databaseModel.executeWithBool("DELETE FROM Degree WHERE (DegreeCode = '" + degreeCode + "');");
        return successfullyRemoved;
    }
    public Boolean removeDegreeLink(String degreeCode, String departmentCode) {
        
        degreeCode = validation.generalValidation(degreeCode);
        departmentCode = validation.generalValidation(departmentCode);

        if (!degreeCode.equals("") && !departmentCode.equals("")) {

            Departments departments = databaseModel.getDepartments("*", "WHERE DepartmentCode='" + departmentCode + "'");
            String departmentName = (String) departments.getDepartmentNames()[0];
            Degrees degrees = databaseModel.getDegrees("*", "WHERE DegreeCode='" + degreeCode + "'");
            String leadDepartment = (String) degrees.getColumn(3)[0];

            if (!departmentName.equals(leadDepartment)) {
                databaseModel.removeFromDatabase("`Department degree (linking)`", "Degree_DegreeCode='" + degreeCode + "' AND " + 
                                                "Department_DepartmentCode='" + departmentCode + "';");
                return true;
            }
        }

        return false;
    }
    
    public Boolean removeModuleLink(String degreeCode, String moduleCode) {

        degreeCode = validation.generalValidation(degreeCode);
        moduleCode = validation.generalValidation(moduleCode);

        if (!degreeCode.equals("") && !moduleCode.equals("")) {

            databaseModel.removeFromDatabase("`Module degree (linking)`", "Degree_DegreeCode='" + degreeCode
                        + "' AND " + "Module_ModuleCode='" + moduleCode + "';");
            return true;
        }
        return false;
    }
}