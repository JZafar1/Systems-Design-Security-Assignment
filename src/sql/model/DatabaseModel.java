package src.sql.model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DatabaseModel {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public void insertIntoDatabase(String table, String values) {
        initConnection();
        initStatement();
        try {
            try {
                openConnection();
                openStatement();
                int count = getStatement().executeUpdate("INSERT INTO " + table + " VALUES " + values + ";");
            }
            finally {
                closeStatement();
                closeConnection();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void initConnection() {connection = null;}
    protected void openConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
    }
    protected void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    protected void initStatement() { statement = null; }
    protected void openStatement() throws SQLException { statement = connection.createStatement(); }
    protected void closeStatement() throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }
    protected void openResultQuery(String query) throws SQLException{
        resultSet = getStatement().executeQuery(query); 
    }
    protected void closeResultQuery() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }
    protected ResultSet getResult() { 
        return resultSet; 
    }
    protected Statement getStatement() {
        if (statement != null) {
            return statement;
        } else {
            return null;
        }
    }
}