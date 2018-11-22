/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sql.model;

import java.sql.SQLException;

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
     
    
}
