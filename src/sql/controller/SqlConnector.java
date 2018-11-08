package src.sql.controller;

import java.sql.*;
import java.util.*;
public class SqlConnector {

    public static void sqlInsert(Connection con) throws SQLException{

        String sqlInsert = "INSERT INTO Department VALUES" +
                            "('COM','Computer Science');";

        try (Statement stmt = con.createStatement()){
            int count = stmt.executeUpdate(sqlInsert);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void sqlQuery(Connection con) throws SQLException{

        String sqlQuery = "SELECT * FROM Department;";
        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery(sqlQuery);

            while (result.next()) {
                String id = result.getString(1);
                String name = result    .getString(2);
                System.out.println("ID : " + id + " | Name : " + name);
            }
            result.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        try (Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa")){
            //sqlInsert(con);
            sqlQuery(con);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}