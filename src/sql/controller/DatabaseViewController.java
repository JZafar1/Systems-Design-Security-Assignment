package src.sql.controller;

import src.sql.model.AdminDatabaseModel;
import src.sql.tables.*;

public class DatabaseViewController {

    private AdminDatabaseModel databaseModel;

    public DatabaseViewController() {
        databaseModel = new AdminDatabaseModel();
    }
    public Object[][] getDepartments() {
        Departments departments = databaseModel.getDepartments("*","");
        return departments.getTable();
    }
    public Object[][] getDegrees(String condition) {
        Degrees degrees = databaseModel.getDegrees("*", condition);
        return degrees.getTable();
    }
    public Object[][] getModules() {
        Modules modules = databaseModel.getModules("*","");
        return modules.getTable();   
    }
    public Object[][] getUsers() {
        Users users = databaseModel.getUsers("*","WHERE Role <> 'Student'");
        return users.getTable();
    }
    public Object[][] getStudents() {
        Students students = databaseModel.getStudents("*","");
        return students.getTable();
    }
    public Object[][] getDegreeLinks() {
        DegreeLinks degreeLinks = databaseModel.getDegreeLinks("*","");
        return degreeLinks.getTable();
    }
    public Object[][] getModuleLinks() {
        ModuleLinks moduleLinks = databaseModel.getModuleLinks("*", "");
        return moduleLinks.getTable();
    }
}