package src.sql.controller;

import src.sql.model.AdminDatabaseModel;
import src.sql.model.RegistrarDatabaseModel;
import src.sql.tables.*;

public class DatabaseViewController {

    private AdminDatabaseModel databaseModel;
    private RegistrarDatabaseModel registrarDatabaseModel;

    public DatabaseViewController() {
        databaseModel = new AdminDatabaseModel();
        registrarDatabaseModel = new RegistrarDatabaseModel();
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
    public Object[][] getRegisteredRecords(String period) {
        Record registeredRecords = registrarDatabaseModel.getRecordsByRegStatus("yes", period);
        return registeredRecords.getTable();
    }
    public Object[][] getUnRegisteredRecords(String period) {
        Record registeredRecords = registrarDatabaseModel.getRecordsByRegStatus("no", period);
        return registeredRecords.getTable();
    }
    public Object[][] getStudentsModules(int recordId) {
        Mark studentsModules = registrarDatabaseModel.getStudentsModules(recordId);
        return studentsModules.getTable();
    }
    
}