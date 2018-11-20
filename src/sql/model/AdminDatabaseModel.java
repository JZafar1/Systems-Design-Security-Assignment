package src.sql.model;

import src.sql.tables.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDatabaseModel extends DatabaseModel {

    public AdminDatabaseModel() {}

    public void insertUsers(String username, byte[] password, String role, String email, String name, String title,
            String surname, byte[] salt) {
        try {
            openConnection();
            openStatement();
            try {
                PreparedStatement ps = getConnection()
                        .prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, username);
                ps.setBytes(2, password);
                ps.setString(3, role);
                ps.setString(4, email);
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
    public Departments getDepartments(String values, String condition) {
        initConnection();
        initStatement();
        Departments departments = new Departments();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Department " + condition + ";");
                while (getResult().next()) {
                    String code = getResult().getString(1);
                    String name = getResult().getString(2);
                    departments.addRow(code, name);
                }
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
        return departments;
    }
    public Degrees getDegrees(String values, String condition) {
        initConnection();
        initStatement();
        Degrees degrees = new Degrees();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Degree " + condition + ";");
                while (getResult().next()) {
                    String code = getResult().getString(1);
                    String name = getResult().getString(2);
                    String levelOfStudy = getResult().getString(3);
                    degrees.addRow(code, name, levelOfStudy);
                }
            }
            finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return degrees;
    }
    public Modules getModules(String values, String condition) {
        initConnection();
        initStatement();
        Modules modules = new Modules();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Module " + condition + ";");
                while (getResult().next()) {
                    String code = getResult().getString(1);
                    String name = getResult().getString(2);
                    String teachingDepartment = getResult().getString(3);
                    modules.addRow(code, name, teachingDepartment);
                }
            }
            finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return modules;
    }
    public Users getUsers(String values, String conditon) {
        initConnection();
        initStatement();
        Users users = new Users();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Users " + conditon + ";");
                while (getResult().next()) {
                    String username = getResult().getString(1);
                    String role = getResult().getString(3);
                    String email = getResult().getString(4);
                    String forename = getResult().getString(5);
                    String title = getResult().getString(6);
                    String surname = getResult().getString(7);
                    users.addRow(role, title, forename, surname, username, email);
                }
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
        return users;
    }
    public Students getStudents(String values, String condition) {
        initConnection();
        initStatement();
        Students students = new Students();
        try {
            try{
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Student JOIN Users USING (Username) " + condition + ";");
                while (getResult().next()) {
                    String username = getResult().getString(1);
                    String regNum = getResult().getString(2);
                    String levelOfStudy = getResult().getString(3);
                    String grade = getResult().getString(4);
                    String degree = getResult().getString(5);
                    String tutor = getResult().getString(6);
                    String email = getResult().getString(9);
                    String forename = getResult().getString(10);
                    String title = getResult().getString(11);
                    String surname = getResult().getString(12);
                    students.addRow(title, forename, surname, username, email,
                                                    regNum, levelOfStudy, grade, degree, tutor);
                }
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
        return students;
    }
    public DegreeLinks getDegreeLinks(String values, String condition) {
        initConnection();
        initStatement();
        DegreeLinks degreeLinks = new DegreeLinks();
        try {
            try{
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM `Department degree (linking)` " + condition + ";");
                while (getResult().next()) {
                    int id = getResult().getInt(1);
                    String departmentCode = getResult().getString(2);
                    String degreeCode = getResult().getString(3);
                    degreeLinks.addRow(id, departmentCode, degreeCode);
                }
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
        return degreeLinks;
    }
}