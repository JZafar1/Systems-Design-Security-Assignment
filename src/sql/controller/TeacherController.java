package src.sql.controller;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import src.sql.controller.*;
import src.sql.model.AdminDatabaseModel;
import src.sql.model.TeacherDatabaseModel;
import src.sql.tables.*;
import java.util.ArrayList;
import java.sql.*;

public class TeacherController {

    private AdminDatabaseModel mainDatabaseModel;
    private TeacherDatabaseModel teacherDatabaseModel;

    public TeacherController() {
        mainDatabaseModel = new AdminDatabaseModel();
        teacherDatabaseModel = new TeacherDatabaseModel();
    }

    public String[] getModuleNames() {
        Modules modules = mainDatabaseModel.getModules("*", "");
        String[] moduleNames = modules.getModuleNames();
        if (moduleNames == null || moduleNames.length == 0) {
            return new String[] {"No modules found"};
        } else {
            return moduleNames;
        }
    }

    public String[] getStudents() {
        Students students = mainDatabaseModel.getStudents("*", "");
        return students.getStudentNames();
    }

    public String [] studentInfo(String cond) {
        Students theStudent = mainDatabaseModel.getStudents("*", cond);
        return theStudent.getStudentInformation();
    }

    public String getStudentTutor(String cond) {
        return teacherDatabaseModel.getTutor(cond);
    }

    public String getDegreeName(String cond) {
        return teacherDatabaseModel.getDegreeName(cond);
    }

    public String getDegree(String cond, String module) {
        return teacherDatabaseModel.getDegreeName(cond, module);
    }

    public void updateGrade(String student, String module, String grade) {
        teacherDatabaseModel.insertGrade(student, module, grade);
    }
}
