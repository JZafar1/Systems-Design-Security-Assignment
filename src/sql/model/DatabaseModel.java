package src.sql.model;

import java.sql.*;
import java.util.*;

public abstract DatabaseModel {

    Connection con;
    Statement stmt;
    ResultSet resultSet;

    public DatabaseModel() {}

    protected void openConnection() {
        con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
    }
    protected void closeConnection() {
        if (con != null) {
            con.close();
        }
    }
    protected void openStatement() { stmt = con.createStatment(); }
    protected void closeStatement() {
        if (stmt != null) {
            stmt.close();
        }
    }
    protected void openResultQuery(String query) {resultSet = getStatement().exceuteQuery(query); }
    protected void closeResultQuery() {
        if (resultSet != null) {
            resultSet.close();
        }
    }
    protected ResultSet getResult() { return resultSet; }
    protected Statement getStatement() {
        if (stmt != null) {
            return stmt;
        } else {
            return null;
        }
    }
}