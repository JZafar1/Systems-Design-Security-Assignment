package src.sql.controller;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import src.sql.controller.*;
import src.sql.model.AdminDatabaseModel;
import src.sql.tables.*;
import java.util.ArrayList;
import java.sql.*;

public class TeacherController {

    private AdminDatabaseModel databaseModel;

    public TeacherController() {
        databaseModel = new AdminDatabaseModel();
    }

    public String[] getModuleNames() {
        Modules modules = databaseModel.getModules("*", "");
        String[] moduleNames = modules.getModuleNames();
        if (moduleNames == null || moduleNames.length == 0) {
            return new String[] {"No modules found"};
        } else {
            return moduleNames;
        }
    }

    public String[] getStudents() {
        Students students = databaseModel.getStudents("*", "");
        return students.getStudentNames();
    }

    public String[] getStudentInfo(String cond) {
        Students theStudent = databaseModel.getStudents("*", cond);
        return theStudent.getStudentInformation();
    }
}
