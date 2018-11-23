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
    
    public ModuleLinks getModuleLinks (String values, String condition) {
        
        initConnection();
        initStatement();
        ModuleLinks availableModules = new ModuleLinks();
        
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Department " + condition + ";");
                while (getResult().next()) {
                    int pairingId = Integer.parseInt(getResult().getString(1));
                    String moduleCode = getResult().getString(2);
                    String degreeCode = getResult().getString(3);
                    String degreeLevel = getResult().getString(4);
                    String season = getResult().getString(5);
                    String credits = getResult().getString(6);
                    String coreOrNot = getResult().getString(7); 
                    availableModules.addRow(moduleCode,degreeCode,degreeLevel,season,credits,coreOrNot);
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
