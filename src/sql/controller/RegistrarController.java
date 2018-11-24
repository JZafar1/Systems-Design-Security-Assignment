/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sql.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import src.sql.model.RegistrarDatabaseModel;
import src.sql.tables.ModuleLinks;
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
        this.validation = new SQLValidation();
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
       
       String registrationNumber = generateRegistrationNumber(0);
       byte[] salt = PasswordHasher.generateSalt();
       byte[] hashedPassword = PasswordHasher.generateHashPassword("123", salt);
       
       String values = "('" + registrationNumber + "','" +  levelOfStudy  + "','" + "','" + username  + "','" +  degreeCode  + "','" + tutor + "')";
       
       databaseModel.insertUsers(username, hashedPassword, role, email, firstname, title, secondname, salt);
       databaseModel.insertIntoDatabase("Student", values);
       registerStudent("2017",registrationNumber);
       
    }
    
    public void registerStudent(String periodOfStudy, String registrationNumber){
        
        periodOfStudy = validation.generalValidation(periodOfStudy);
        registrationNumber = validation.generalValidation(registrationNumber);
        
        createRecord(periodOfStudy, registrationNumber);
        int recordId = databaseModel.getRecordId(registrationNumber,periodOfStudy);
        
        String degreeCode = databaseModel.getStudentDegree(registrationNumber);
        String degreeName = databaseModel.getDegreeName(degreeCode);
        
        ModuleLinks coreModules = databaseModel.getValidOptionalCoreModules (degreeCode,degreeName,true);
        
        String [] codes = coreModules.getModuleCodes();
        
        for(int i = 0; i<codes.length; i++){
            System.out.println(codes[i]);
            addMark(recordId,codes[i]);
        }
    }
    
    public void createRecord (String periodOfStudy, String registrationNumber){
        
        periodOfStudy = validation.generalValidation(periodOfStudy);
        registrationNumber = validation.generalValidation(registrationNumber);
        
        int recordId = generateRecordId(0);
        int average = 0;
        String honour = "none";
        
        String values = "('" + recordId + "','" + average  + "','" + honour + "','" + registrationNumber  + "','" + periodOfStudy + "','no')";
        
        databaseModel.insertIntoDatabase("Record", values);
        
    }
    
    public void addMark (int recordId, String moduleCode){
        
        moduleCode = validation.generalValidation(moduleCode);
        
        int markId = generateMarkId(0);
        
        String values = "('" + markId + "','" + moduleCode  + "','" + recordId + "','-1','-1' )";
        
        databaseModel.insertIntoDatabase("Mark", values);
    }
    
    public void removeMark (String markId){
        
        markId = validation.generalValidation(markId);
        String conditions = "(`Mark ID` = '" + markId + "')" ;
        databaseModel.removeFromDatabase("Mark",conditions);
        
    }
    
    public void removeStudent (String username){
       
       username = validation.generalValidation(username);
        
       String conditionsStudent = "(Username = '" + username + "');";
       String conditionsUser = "(Username = '" + username + "');";
       
       databaseModel.removeFromDatabase("Student", conditionsStudent);
       databaseModel.removeFromDatabase("Users",conditionsUser);
    }
    
    private int generateMarkId(int i){
        
        boolean bool = databaseModel.executeBoolQuery("SELECT * FROM Mark WHERE (`Mark ID` = '" + i + "')");
        if(bool) return generateRecordId(i+1);
        else return i;
        
    }
    
    private int generateRecordId(int i){
        
        boolean bool = databaseModel.executeBoolQuery("SELECT * FROM Record WHERE (`Record ID` = '" + i + "')");
        if(bool) return generateRecordId(i+1);
        else return i;
        
    }
    
    private String generateRegistrationNumber(int i) {
        
        String numberBase = "" + i;
        while(numberBase.length() < 6) numberBase = 0 + numberBase;
        
        boolean bool = databaseModel.executeBoolQuery("SELECT * FROM Student WHERE (`Registration number` = '" + numberBase + "')");
        
        if(bool) return generateRegistrationNumber(i+1);
        else return numberBase;
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
