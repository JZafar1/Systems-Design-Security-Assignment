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
    public ArrayList<Degree> getDegrees(String values) {
        initConnection();
        initStatement();
        ArrayList<Degree> degreeList = new ArrayList<Degree>();
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
                    Degree degree = new Degree(code, name, yearInIndustry, levelOfStudy);
                    degreeList.add(degree);
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
        return degreeList;
    }
    public ArrayList<Module> getModules(String values) {
        initConnection();
        initStatement();
        ArrayList<Module> moduleList = new ArrayList<Module>();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Module;");
                while (getResult().next()) {
                    String code = getResult().getString(1);
                    String name = getResult().getString(2);
                    Module module = new Module(code, name);
                    moduleList.add(module);
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
        return moduleList;
    }
    public ArrayList<User> getUsers(String values, String conditon) {
        initConnection();
        initStatement();
        ArrayList<User> userList = new ArrayList<User>();
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
                    User user = new User(role, title, forename, surname, username, email);
                    userList.add(user);
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
        return userList;
    }
    public ArrayList<Student> getStudents(String values) {
        initConnection();
        initStatement();
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            try{
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM Student, Users USING (username);");
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
                    Student student = new Student(title, forename, surname, username, email,
                                                    regNum, levelOfStudy, grade, degree, tutor);
                    studentList.add(student);
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
        return studentList;
    }
}