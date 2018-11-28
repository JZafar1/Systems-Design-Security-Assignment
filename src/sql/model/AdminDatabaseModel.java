package src.sql.model;

import src.sql.tables.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDatabaseModel extends DatabaseModel {

    public AdminDatabaseModel() {}
    
    public boolean executeBoolQuery(String query){
        
        initConnection();
        initStatement();
        boolean bool = false;
        
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery(query);
                bool = getResult().next();
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
        
        return bool;
    }

    public void insertUsers(String username, byte[] password, String role, String email, String name, String title,
            String surname, byte[] salt) {
        try {
            openConnection();
            //openStatement();
            PreparedStatement prepStatement = getConnection().prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            try {
                prepStatement.setString(1, username);
                prepStatement.setBytes(2, password);
                prepStatement.setString(3, role);
                prepStatement.setString(4, email);
                prepStatement.setString(5, name);
                prepStatement.setString(6, title);
                prepStatement.setString(7, surname);
                prepStatement.setBytes(8, salt);
                prepStatement.executeUpdate();
            } finally {
                prepStatement.close();
                //scloseStatement();
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
                    String leadDepartment = getResult().getString(4);
                    degrees.addRow(code, name, levelOfStudy, leadDepartment);
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
    
    public Period getPeriods(String values, String condition) {
        initConnection();
        initStatement();
        Period periods = new Period();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT " + values + " FROM `Period of study` " + condition + ";");
                while (getResult().next()) {
                    String label = getResult().getString(1);
                    String start = getResult().getString(2);
                    String end = getResult().getString(3);
                    periods.addRow(label, start, end);
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
        return periods;
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
        if (condition.length()==0)
            condition = "true";
        initConnection();
        initStatement();
        DegreeLinks degreeLinks = new DegreeLinks();
        try {
            try{
                openConnection();
                openStatement();
                openResultQuery("SELECT dll.Degree_DegreeCode, deg.`Degree name`, dll.Department_DepartmentCode, dept.`Full name` " + 
                                "FROM Department dept, Degree deg, `Department degree (linking)` dll " + 
                                "WHERE dept.DepartmentCode = dll.Department_DepartmentCode AND deg.DegreeCode = dll.Degree_DegreeCode AND " +
                                condition + 
                                " ORDER BY dll.Degree_DegreeCode;");
                while (getResult().next()) {
                    String degreeCode = getResult().getString(1);
                    String degreeName = getResult().getString(2);
                    String departmentCode = getResult().getString(3);
                    String departmentName = getResult().getString(4);
                    degreeLinks.addRow(degreeCode, degreeName, departmentCode, departmentName);
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
    
    public ModuleLinks getModuleLinks(String values, String condition) {
        if (condition.length() == 0)
            condition = "true";
        initConnection();
        initStatement();
        ModuleLinks moduleLinks = new ModuleLinks();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT mdl.Degree_DegreeCode, deg.`Degree name`, mdl.Module_ModuleCode, " + 
                                            "mdule.`Full name`, mdl.`Level`, mdl.season, mdl.credits, mdl.CoreOrNot " +
                                "FROM Module mdule, Degree deg, `Module degree (linking)` mdl " + 
                                "WHERE mdl.Module_ModuleCode = mdule.ModuleCode AND mdl.Degree_DegreeCode = deg.DegreeCode AND " + 
                                condition +
                                " ORDER BY mdl.Degree_DegreeCode;");
                while (getResult().next()) {
                    String degreeCode = getResult().getString(1);
                    String degreeName = getResult().getString(2);
                    String moduleCode = getResult().getString(3);
                    String moduleName = getResult().getString(4);
                    String level = getResult().getString(5);
                    String semester = getResult().getString(6);
                    String credits = getResult().getString(7);
                    String coreOrNot = getResult().getString(8);
                    moduleLinks.addRow(degreeCode, degreeName, moduleCode, moduleName, level, semester, credits, coreOrNot);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return moduleLinks;
    }
}