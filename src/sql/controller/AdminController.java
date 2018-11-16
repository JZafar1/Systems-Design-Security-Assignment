package src.sql.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import src.ui.admin.*;
import src.sql.controller.PasswordHasher;
import src.sql.model.*;
import src.sql.tables.Departments;
import src.sql.tables.Degrees;
import src.sql.tables.Modules;

public class AdminController {

    private AdminDatabaseModel databaseModel;

    public AdminController() {
        databaseModel = new AdminDatabaseModel();
    }
    public String[] getDepartmentNames() {
        Departments departments = databaseModel.getDepartments("*");
        return departments.getDepartmentNames();
    }
    public String[] getDegreeNames() {
        Degrees degrees = databaseModel.getDegrees("*");
        return degrees.getDegreeNames();
    }
    public void addDepartment(String name){
        
        String departmentCode = name.substring(0,3).toUpperCase();
        String values = "('" + departmentCode + "','"  + name + "')";
        
        databaseModel.insertIntoDatabase("Department",values);
                
    }
    public void addUser(String name, String surname, String password, String role) {
        
        int count = 1;

        byte[] salt = PasswordHasher.generateSalt();
        byte[] hashedPassword = PasswordHasher.generateHashPassword(password, salt);

        System.out.println(hashedPassword);

        String username = name + surname + count;
        String email = username + "@sheffield.ac.uk";
        String title = "Mr.";
        /*String values = "('" + username + "','" + hashedPassword + "','"  + role + "','" + email + "','" + 
                               name + "','" + title + "','" + surname + "','" + salt+"')";*/
        
        //databaseModel.insertIntoDatabase("Users",values);
        databaseModel.insertUsers(username, hashedPassword, role, email, name, title, surname, salt);
        
    }
    public void addDegree(String name, String leadDepartment, String levelOfStudy) {

        String serialNumber = "03";
        String degreeCode = leadDepartment + "U" + serialNumber;
        String values = "('" + degreeCode + "','" + name +  "','" + levelOfStudy + "')";

        databaseModel.insertIntoDatabase("Degree", values);

    }
    public void addModule(String name, String teachingDepartment) {
        String departmentCode = teachingDepartment.substring(0,3).toUpperCase();
        Modules modules = databaseModel.getModules("*", "WHERE ModuleCode LIKE '" + departmentCode + "%'");
        String moduleCode = modules.generateModuleCode(departmentCode);
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
    public void removeDegree(String leadDepartment){
        String degreeCode = leadDepartment + "U03";
        String conditions = "(DegreeCode = '" + degreeCode + "');";
        
        databaseModel.removeFromDatabase("Degree",conditions);
    }
    private String generatePassword(int length){
        
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        Random randomVariable = new Random();
        for(int i =0; i<length;i++){
            password += characters.charAt(randomVariable.nextInt(characters.length()));
        }
        
        return password;
        
    }
    
}