package src.sql.model;

import src.sql.tables.*;
import java.sql.*;
import java.util.*;

public class AdminDatabaseModel extends DatabaseModel {

    public AdminDatabaseModel() {}
    
    public ArrayList<Department> getDepartments(String values) throws SQLException {
        openConnection();
        openStatement();
        ArrayList<Department> departmentList = new ArrayList<Department>();
        try {
            openResultQuery("SELECT " + values + " FROM Department;");
            while (getResult().next()) {
                String code = getResult().getString(1);
                String name = getResult().getString(2);
                Department department = new Department(code, name);
                departmentList.add(department);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeResultQuery();
            closeStatement();
            closeConnection();
            return departmentList;
        }
    }
    public ArrayList<Degree> getDegrees(String values) throws SQLException {
        openConnection();
        openStatement();
        ArrayList<Degree> degreeList = new ArrayList<Degree>();
        try {
            openResultQuery("SELECT " + values + " FROM Degree;");
            while (getResult().next()) {
                String code = getResult().getString(1);
                String name = getResult().getString(2);
                String yearInIndustry = getResult().getString(3);
                String levelOfStudy = getResult().getString(4);
                Degree degree = new Degree(code, name, yearInIndustry, levelOfStudy);
                degreeList.add(degree);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultQuery();
            closeStatement();
            closeConnection();
            return degreeList;
        }
    }
    public ArrayList<Module> getModules(String values) throws SQLException {
        openConnection();
        openStatement();
        ArrayList<Module> moduleList = new ArrayList<Module>();
        try {
            openResultQuery("SELECT " + values + " FROM Module;");
            while (getResult().next()) {
                String code = getResult().getString(1);
                String name = getResult().getString(2);
                Module module = new Module(code, name);
                moduleList.add(module);
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeResultQuery();
            closeStatement();
            closeConnection();
            return moduleList;
        }
    }
    public ArrayList<User> getUsers(String values, String conditon) throws SQLException {
        openConnection();
        openStatement();
        ArrayList<User> userList = new ArrayList<User>();
        try {
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
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeResultQuery();
            closeStatement();
            closeConnection();
            return userList;
        }
    }
    public ArrayList<Student> getStudents(String values) throws SQLException {
        openConnection();
        openStatement();
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
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
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            closeResultQuery();
            closeStatement();
            closeConnection();
            return studentList;
        }
    }
}