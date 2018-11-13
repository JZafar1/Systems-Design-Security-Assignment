package src.sql.model;

import src.sql.tables.*;
import java.sql.*;
import java.util.*;

public class AdminDatabaseModel extends DatabaseModel {

    public AdminDatabaseModel() {}
    
    public Departments getDepartments(String values) {
        initConnection();
        initStatement();
        Departments departments = new Departments();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Department;");
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
    public Degrees getDegrees(String values) {
        initConnection();
        initStatement();
        Degrees degrees = new Degrees();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Degree;");
                while (getResult().next()) {
                    String code = getResult().getString(1);
                    String name = getResult().getString(2);
                    String yearInIndustry = getResult().getString(3);
                    String levelOfStudy = getResult().getString(4);
                    degrees.addRow(code, name, yearInIndustry, levelOfStudy);
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
    public Students getStudents(String values) {
        initConnection();
        initStatement();
        Students students = new Students();
        try {
            try{
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Student JOIN Users USING (Username);");
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
}