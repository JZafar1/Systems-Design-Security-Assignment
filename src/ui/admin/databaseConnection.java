/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.ui.admin;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Mieszko
 */
public class databaseConnection {
    
    public void checkDrivers(){
        
        System.out.println("\nDrivers loaded as properties:");
        System.out.println(System.getProperty("jdbc.drivers"));
        System.out.println("\nDrivers loaded by DriverManager:");
        Enumeration<Driver> list = DriverManager.getDrivers();
        while (list.hasMoreElements()) 
        System.out.println(list.nextElement());
        
    }
    
    public static void makeAnUpdate(String command) throws SQLException{
        
        Connection con = null;  // a Connection object
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa"); 

            Statement statement = null;
            try{

                statement = con.createStatement();
                int countRowsUpdated = statement.executeUpdate(command);

            }
            catch(SQLException exception){
                exception.printStackTrace();
            }
            finally{
                if(statement != null) statement.close();
            }
          
        }
        
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        finally {
            if (con != null) con.close();
        }
        
    }
    
}
