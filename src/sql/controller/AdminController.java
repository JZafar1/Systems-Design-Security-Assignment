package src.sql.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import src.ui.admin.*;
import src.sql.model.*;
import src.sql.tables.Departments;
import src.sql.tables.Modules;

public class AdminController{

    private AdminDatabaseModel databaseModel;

    public AdminController() {
        databaseModel = new AdminDatabaseModel();
    }
    public String[] getDepartmentNames() {
        Departments departments = databaseModel.getDepartments("*");
        return departments.getDepartmentNames();
    }
    public void addDepartment(String name){
        
        String departmentCode = name.substring(0,3).toUpperCase();
        String values = "('" + departmentCode + "','"  + name + "')";
        
        databaseModel.insertIntoDatabase("Department",values);
                
    }
    public void addUser(String name, String surname, String role){
        
        int count = 1;
        String username = name + surname + count;
        String email = username + "@sheffield.ac.uk";
        String password = generatePassword(12);
        String title = "Mr.";
        String values = "('" + username + "','" + password + "','"  + role + "','" + email + "','" + name + "','" + title + "','" + surname + "')";
        
        databaseModel.insertIntoDatabase("Users",values);
        
    }
    public void addDegree(String name, String leadDepartment, String level, String placement) {

        String serialNumber = "03";
        String degreeCode = leadDepartment + "U" + serialNumber;
        String values = "('" + degreeCode + "','" + name + "','" + placement + "','" + level + "')";

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
    public void removeUser(String name, String surname){
        String username = name + surname + "1";
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