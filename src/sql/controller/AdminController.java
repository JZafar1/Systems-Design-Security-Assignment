package src.sql.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import src.ui.admin.*;
import src.sql.model.*;


public class AdminController{
    
    public static void addDepartment(String name){
        
        String departmentCode = name.substring(0,3);
        String values = "('" + departmentCode + "','"  + name + "')";
        
        DatabaseModel.insertIntoDatabase("Department",values);
                
    }
    
    public static void addUser(String name, String surname, String role){
        
        int count = 1;
        String username = name + surname + count;
        String email = username + "@sheffield.ac.uk";
        String password = generatePassword(12);
        String title = "Mr.";
        String values = "('" + username + "','" + password + "','"  + role + "','" + email + "','" + name + "','" + title + "','" + surname + "')";
        
        DatabaseModel.insertIntoDatabase("Users",values);
        
    }
    
    public static void addDegree(String name,String leadDepartment,String level,String placement){
        
        String serialNumber  = "03";
        String degreeCode = leadDepartment + "U" + serialNumber;
        String values = "('" + degreeCode+ "','" + name + "','"  + placement + "','" + level + "')";
        
        DatabaseModel.insertIntoDatabase("Degree",values);
        
    }
    
    public static void addModule(String name){
        
        String values = "('code1','" + name + "')";
        
        DatabaseModel.insertIntoDatabase("Module",values);
    }
    
    private static String generatePassword(int length){
        
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String password = "";
        Random randomVariable = new Random();
        for(int i =0; i<length;i++){
            password += characters.charAt(randomVariable.nextInt(characters.length()));
        }
        
        return password;
        
    }
    
}