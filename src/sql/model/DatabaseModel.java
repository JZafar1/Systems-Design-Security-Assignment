package src.sql.model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DatabaseModel {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public void insertIntoDatabase(String table, String values){
        execute("INSERT INTO " + table + " VALUES " + values + ";");
    }

    public void insertUsers(String username, byte[] password, String role, String email, String name, String title, String surname, byte[] salt) {
        try {
            openConnection();
            openStatement();
            try {
                PreparedStatement ps = getConnection().prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, username);
                ps.setBytes(2, password);
                ps.setString(3, role);
                ps.setString(4,email);
                ps.setString(5, name);
                ps.setString(6, title);
                ps.setString(7, surname);
                ps.setBytes(8, salt);
                ps.executeUpdate();
                ps.close();
            } finally {
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeFromDatabase(String table, String conditions){
        execute("DELETE FROM " + table + " WHERE " + conditions + ";");
    }
    
    private void execute(String querry){
        try{
            openConnection();
            openStatement();
            try {
                int count = getStatement().executeUpdate(querry);
            }
            finally {
                closeStatement();
                closeConnection();
            }
        } 
        catch (SQLException ex){
            Logger.getLogger(DatabaseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void initConnection() {
        connection = null;
    }
    
    protected void openConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
    }
    protected Connection getConnection() throws SQLException {
        return connection;
    }
    protected void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    protected void initStatement() {
        statement = null; 
    }
    
    protected void openStatement() throws SQLException {
        statement = connection.createStatement(); 
    }
    
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