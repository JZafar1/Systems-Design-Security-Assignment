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

    public int getWeightedMean(String student) {
        int mean = teacherDatabaseModel.getWeightedMean(student);
        return mean;
    }

    public String getDegreeResult(String student) {
        final int theMeanGrade = getWeightedMean(student);
        if(theMeanGrade <= 39.5) {
            return "FAIL";
        }else {
            String type = getDegreeType(student);
            if(type == "Bsc" || type == "BEng") {
                return getBachelorResult(theMeanGrade);
            }else if(type == "Msc" || type == "MEng") {
                return getMasterResult(theMeanGrade);
            }else {
                return getOneYearResult(theMeanGrade);
            }
        }
    }

    public String getDegreeType(String student) {
        return "Bsc";
    }

    public String getBachelorResult(final int theGrade) {
        if(theGrade <= 44.4) {
            return "Pass (non-honours)";
        }else if((theGrade >= 44.5) && (theGrade <= 49.4)) {
            return "Third Class";
        }else if((theGrade >= 49.5) && (theGrade <= 59.4)) {
            return "Lower Second";
        }else if((theGrade >= 59.5) && (theGrade <= 69.4)) {
            return "Upper Second";
        }else {
            return "First Class";
        }
    }

    public String getMasterResult(final int theGrade) {
        if(theGrade <= 49.4) {
            return "FAIL";
        }else if((theGrade >= 49.5) && (theGrade <= 59.4)) {
            return "Lower Second";
        }else if((theGrade >= 59.5) && (theGrade <= 69.4)) {
            return "Upper Second";
        }else {
            return "First Class";
        }
    }

    public String getOneYearResult(final int theGrade) {
        if(theGrade <= 49.4) {
            return "FAIL";
        }else if((theGrade >= 49.5) && (theGrade <= 59.4)) {
            return "Pass";
        }else if((theGrade >= 59.5) && (theGrade <= 69.4)) {
            return "Merit";
        }else {
            return "Distinction";
        }
    }

    public void registerStudent(String theResult, String student) {
        if(theResult.equalsIgnoreCase("Fail")) {
            String res = studentFailed(student);
        }
    }

    public String studentFailed(String name) {
        String type = getDegreeType(name);
        int level = getLevelOfStudy(name);
        if(level == 3 && type.equalsIgnoreCase("Bsc")) {
            return "Resit for pass(non-honours) degree";
        }else if(level == 4) {
            return "Pass with bachelor’s degree";
        }else {
            return "Re-sit current year";
        }
    }

    public int getLevelOfStudy(String theName) {
        return teacherDatabaseModel.getLevelOfStudy(theName);
    }
}
