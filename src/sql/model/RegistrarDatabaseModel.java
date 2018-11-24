/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sql.model;

import java.sql.SQLException;
import src.sql.tables.*;

/**
 *
 * @author aca17mss
 */
public class RegistrarDatabaseModel extends AdminDatabaseModel{
    
    public int getRecordId(String studentRegistrationNumber, String periodOfStudy){
        
        initConnection();
        initStatement();
        int recordId = 0;
        
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT 'Record ID' FROM Department WHERE 'Student_Registration number' = '" + studentRegistrationNumber + "' AND 'Period of study_Label' = '" + periodOfStudy +  "' ;");
                recordId = Integer.parseInt(getResult().getString(1));
            }
            finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }   
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return recordId;
        
    }
    
    public ModuleLinks getValidModules (String degreeCode, String degreeName) {
        
        initConnection();
        initStatement();
        ModuleLinks availableModules = new ModuleLinks();
        
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT * FROM `Module degree (linking)` INNER JOIN `Module`  ON `Module degree (linking)`.Module_ModuleCode = `Module`.ModuleCode WHERE Degree_DegreeCode = '" + degreeCode + "';");
                while (getResult().next()) {
                    int pairingId = Integer.parseInt(getResult().getString(1));
                    String moduleCode = getResult().getString(2);
                    String moduleName = getResult().getString(9);
                    String degreeLevel = getResult().getString(4);
                    String season = getResult().getString(5);
                    String credits = getResult().getString(6);
                    String coreOrNot = getResult().getString(7); 
                    availableModules.addRow(degreeCode,degreeName,moduleCode,moduleName,degreeLevel,season,credits,coreOrNot);
                }
            }
            finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }   
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return availableModules;
        
    }
    
    public ModuleLinks getValidOptionalCoreModules (String degreeCode, String degreeName, boolean isCore) {
        
        initConnection();
        initStatement();
        ModuleLinks availableModules = new ModuleLinks();
        String core;
        if(isCore)core = "'Core'";
        else core = "'Not Core'";
        
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT * FROM `Module degree (linking)` INNER JOIN `Module`  ON `Module degree (linking)`.Module_ModuleCode = `Module`.ModuleCode WHERE Degree_DegreeCode = '" + degreeCode + "' AND CoreOrNot = " + core + ";");
                while (getResult().next()) {
                    int pairingId = Integer.parseInt(getResult().getString(1));
                    String moduleCode = getResult().getString(2);
                    String moduleName = getResult().getString(9);
                    String degreeLevel = getResult().getString(4);
                    String season = getResult().getString(5);
                    String credits = getResult().getString(6);
                    String coreOrNot = getResult().getString(7); 
                    availableModules.addRow(degreeCode,degreeName,moduleCode,moduleName,degreeLevel,season,credits,coreOrNot);
                }
            }
            finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }   
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return availableModules;
        
    }
    
}
