package src.sql.model;

import java.sql.*;
import java.util.*;

public abstract class DatabaseModel {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    protected void openConnection() {
        connection = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
    }
    protected void closeConnection() {
        if (connection != null) {
            connection.close();
        }
    }
    protected void openStatement() { 
        statement = connection.createStatement(); 
    }
    protected void closeStatement() {
        if (statement != null) {
            statement.close();
        }
    }
    protected void openResultQuery(String query) {
        resultSet = getStatement().executeQuery(query); 
    }
    protected void closeResultQuery() {
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