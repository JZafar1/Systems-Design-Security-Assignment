/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectingToDatabaseExample;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Mieszko
 */
public class connectingToDatabseExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        /* IMPORTANT this part of code checks the drivers. Don't min "null" in the first line it seems to be an expected outcome (based on lectures)*/
        
        System.out.println("\nDrivers loaded as properties:");
        System.out.println(System.getProperty("jdbc.drivers"));
        System.out.println("\nDrivers loaded by DriverManager:");
        Enumeration<Driver> list = DriverManager.getDrivers();
        while (list.hasMoreElements()) 
        System.out.println(list.nextElement());
        
        /* IMPORTANT this part of code makes the actuall connection and is used to execute Querries */
        
        Connection con = null;  // a Connection object
        try {
          con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa"); 
           
           //ALL THE QUEREIES CODE GOES HERE
           
           
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if (con != null) con.close();
        }


        
    }
    
}
