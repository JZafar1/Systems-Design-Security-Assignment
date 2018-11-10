package src.sql.model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DatabaseModel {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    
    public static void insertIntoDatabase(String table, String values){
        
        try {
            openConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            openStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            int count = getStatement().executeUpdate("INSERT INTO " + table + " VALUES " + values + ";");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                closeStatement();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected static void openConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
    }
    protected static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    protected static void openStatement() throws SQLException { 
        statement = connection.createStatement(); 
    }
    protected static void closeStatement() throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }
    protected static void openResultQuery(String query) throws SQLException {
        resultSet = getStatement().executeQuery(query); 
    }
    protected static void closeResultQuery() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }
    protected static ResultSet getResult() { 
        return resultSet; 
    }
    protected static Statement getStatement() {
        if (statement != null) {
            return statement;
        } else {
            return null;
        }
    }
}