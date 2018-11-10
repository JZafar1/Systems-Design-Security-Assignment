package src.sql.model;

import java.sql.*;
import java.util.*;

public class AdminDatabaseModel extends DatabaseModel {

    public AdminDatabaseModel() {}
    
    public void insertIntoDatabase(String table, String values) throws SQLException {
        openConnection();
        openStatement();
        try {
            int count = getStatement().executeUpdate("INSERT INTO " + table + " VALUES " + values + ";");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeStatement();
            closeConnection();
        }
    }
    public ArrayList<Departments> getDepartments(String values) throws SQLException {
        openConnection();
        openStatement();
        ArrayList<Deparments> departmentList = new ArrayList<Departments>();
        try {
            ResultSet res = getStatment().executeQuery("SELECT " + values + " FROM Department;");
            while (res.next()) {
                String code = res.getString(1);
                String name = res.getString(2);
                Department department = new Department(code, name);
                departmentList.add(department);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeStatement();
            closeConnection();
            return departmentList;
        }
    }
}