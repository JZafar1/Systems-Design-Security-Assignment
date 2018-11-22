/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sql.controller;

import java.util.ArrayList;
import src.sql.model.RegistrarDatabaseModel;
import src.sql.tables.Users;

/**
 *
 * @author aca17mss
 */
public class RegistrarController {
    
    private RegistrarDatabaseModel databaseModel;
    private SQLValidation validation;

    public RegistrarController() {
        this.databaseModel = new RegistrarDatabaseModel();
        this.validation = validation;
    }
    
    public void addStudent(String levelOfStudy, String firstname, String secondname, String degreeCode, String tutor) {
        
       levelOfStudy = validation.generalValidation(levelOfStudy);
       firstname = validation.generalValidation(firstname);
       secondname = validation.generalValidation(secondname);
       degreeCode = validation.generalValidation(degreeCode);
       tutor = validation.generalValidation(tutor);
       
       String baseUsername = (firstname.substring(0, 1) + secondname).toLowerCase();
       Users users = databaseModel.getUsers("*","WHERE Username LIKE '" + baseUsername + "%';");
       String username = generateUsername(baseUsername, users.getTableList());

       String email = username + "@sheffield.ac.uk";
       String title = "Mr.";
       String role = "Student";
       
       String registrationNumber = generateRegistrationNumber();
       byte[] salt = PasswordHasher.generateSalt();
       byte[] hashedPassword = PasswordHasher.generateHashPassword("123", salt);
       
       String values = "('" + registrationNumber + "','" +  levelOfStudy  + "','" + "','" + username  + "','" +  degreeCode  + "','" + tutor + "')";
       
       databaseModel.insertIntoDatabase("Student", values);
       databaseModel.insertUsers(username, hashedPassword, role, email, firstname, title, secondname, salt);
       
    }
    
    private String generateRegistrationNumber() {
        
        return "12345678";
        
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
    
    
    
    
    
}
