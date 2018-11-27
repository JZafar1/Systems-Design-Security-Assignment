package src.sql.controller;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import src.sql.controller.*;
import src.sql.model.AdminDatabaseModel;
import src.sql.model.TeacherDatabaseModel;
import src.sql.tables.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class TeacherController {

    private AdminDatabaseModel mainDatabaseModel;
    private TeacherDatabaseModel teacherDatabaseModel;

    public TeacherController() {
        mainDatabaseModel = new AdminDatabaseModel();
        teacherDatabaseModel = new TeacherDatabaseModel();
    }

    //Get full list of modules and module codes
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

    //All student information
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

    //Get grade for a given module
    public String getGrade(String cond, String module) {
        return teacherDatabaseModel.getCurrentGrade(cond, module);
    }

    public void updateGrade(String student, String module, String grade, boolean resit) {
        if(resit) {
            grade = "40";
        }
        teacherDatabaseModel.insertGrade(student, module, grade, resit);
    }

    //Calculate the degree result for a given year
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

    //Check if degree is bachelor/master/1 year MSc
    public String getDegreeType(String student) {
        int theLength = teacherDatabaseModel.getDegreeType(student);
        if(theLength == 3) {
            return "BSc";
        }else if(theLength == 4) {
            return "MSc";
        }else {
            return "One Year Msc";
        }
    }

    //Get the degree result for a given year
    public String getBachelorResult(final double theGrade) {
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

    public String getMasterResult(final double theGrade) {
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

    public String getOneYearResult(final double theGrade) {
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
            return "Null";
        }
    }

    public int getLevelOfStudy(String theName) {
        return teacherDatabaseModel.getLevelOfStudy(theName);
    }

    public int getWeightedMean(String student) {
        int weightedMean = 0;
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
        ArrayList<Integer> theModules = new ArrayList<Integer>();
        allGrades = teacherDatabaseModel.getGradeList(student);
        theModules = getCreditValue(student);
        int divisor = 0;
        if(getLevelOfStudy(student) == 4) {
            divisor = 180;
        }else{
            divisor = 120;
        }
        for(int i = 0; i < allGrades.size(); i++) {
            weightedMean += (allGrades.get(i) * (int)(theModules.get(i) / divisor));
        }
        return weightedMean;
    }

    //Get a list of all periods of study
    public ArrayList<Integer> getPeriodsofStudy(String student) {
        String query = "SELECT `Period of study_Label` FROM Record WHERE "
            + "Student_Registration number = '" + student + "';";
        ArrayList<String> results = new ArrayList<String>();
        results = teacherDatabaseModel.getPeriodOfStudy(query);
        ArrayList<Integer> resultAsInt = new ArrayList<Integer>(results.size()) ;
        for (String temp : results) {
            resultAsInt.add(Integer.valueOf(temp));
        }
        return resultAsInt;
    }

    //Add weighted mean to database
    public void updateWeightedMean(String student) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        int theMean = getWeightedMean(student);
        String query = "UPDATE Record SET Average = '" + theMean + "' WHERE "
            + "`Period of study_Label` = '" + currentYear + "';";
    }

    public ArrayList<Integer> getCreditValue(String student) {
        String record = getRecordId(student);
        ArrayList<String> moduleCodes = new ArrayList<String>();
        moduleCodes = teacherDatabaseModel.getStudentModuleCode(record);
        ArrayList<Integer> creditValues = new ArrayList<Integer>();
        for(int i = 0; i < moduleCodes.size(); i++) {
            creditValues.add(teacherDatabaseModel.getCredits(moduleCodes.get(i)));
        }
        return creditValues;
    }

    public String getRecordId(String student) {
        String query = "WHERE `Student_Registration number` = '" + student + "';";
        return teacherDatabaseModel.getRecordId(query);
    }

    public boolean checkMinGradeReq(String student) {
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
        allGrades = teacherDatabaseModel.getGradeList(student);
        int minGrade = allGrades.indexOf(Collections.min(allGrades));
        if(getLevelOfStudy(student) != 4) {
            return (minGrade < 29.5);
        }else {
            return (minGrade < 39.5);
        }
    }

    public boolean checkMinCreditsReq(String student) {
        int totalCreds = creditsAchieved(student);
        if(!checkMinGradeReq(student)) {
            return true;
        }else {
            if(getLevelOfStudy(student) == 4) {
                return (totalCreds >= 165);
            }else {
                return (totalCreds >= 100);
            }
        }
    }

    public int creditsAchieved(String student) {
        ArrayList<Integer> credits = new ArrayList<Integer>();
        credits = getCreditValue(student);
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
        allGrades = teacherDatabaseModel.getGradeList(student);
        int totalCreds = 0;
        for(int i = 0; i < allGrades.size(); i++) {
            if(getLevelOfStudy(student) != 4) {
                if(allGrades.get(i) >= 39.5) {
                    totalCreds += credits.get(i);
                }
            }else {
                if(allGrades.get(i) >= 49.5) {
                    totalCreds += credits.get(i);
                }
            }
        }
        return totalCreds;
    }

    //Return 1 to be considered for PGDip 0 for PGCert, -1 for fail
    public int checkDissertationGrade(String student) {
        ArrayList<String> possibleModules = teacherDatabaseModel.getDissertationModules();
        ArrayList<String> stuModules = teacherDatabaseModel.getStudentModuleCode(getRecordId(student));
        String theModule = "";
        for(int i = 0; i < stuModules.size(); i++) {
            if(stuModules.get(i) == possibleModules.get(i)) {
                theModule = possibleModules.get(i);
            }
            if(possibleModules.size() == (i - 1)) {
                return -1;
            }
        }
        int grade = Integer.parseInt(teacherDatabaseModel.getCurrentGrade(student, theModule));
        if(grade >= 49.5) {
            return 1;
        }else {
            if(creditsAchieved(student) == 120) {
                return 1;
            }else if(creditsAchieved(student) >= 60) {
                return 0;
            }else {
                return -1;
            }
        }
    }

    public String calculateFinalResult(String student) {
        ArrayList<Integer> studyPeriods = getPeriodsofStudy(student);
        double currentYear = Collections.max(studyPeriods);
        String query = "SELECT Average FROM Record WHERE "
        + "`Student_Registration number` = '" + student + " AND "
        + "``Period of study_Label` = '" + currentYear + "';";
        int thisYearResult = teacherDatabaseModel.getWeightedMean(query);
        query ="SELECT Average FROM Record WHERE "
        + "`Student_Registration number` = '" + student + " AND "
        + "``Period of study_Label` = '" + (currentYear - 1) + "';";
        double lastYearResult = teacherDatabaseModel.getWeightedMean(query);
        if(getLevelOfStudy(student) == 3  && getDegreeType(student) == "BSc") {;
            double totalAverage = (thisYearResult * (2/3)) + (lastYearResult * (1/3));
            totalAverage = roundResults(totalAverage);
            return getBachelorResult(totalAverage);
        }else if(getLevelOfStudy(student) == 4 && getDegreeType(student) == "MSc") {
            query ="SELECT Average FROM Record WHERE "
            + "`Student_Registration number` = '" + student + " AND "
            + "``Period of study_Label` = '" + (currentYear - 2) + "';";
            double twoYearRes = teacherDatabaseModel.getWeightedMean(query);
            double totalAverage = (thisYearResult * (2/5)) + (lastYearResult * (2/5))
                + (twoYearRes * (1/5));
            totalAverage = roundResults(totalAverage);
            return getMasterResult(totalAverage);
        }else {
            return getOneYearResult(thisYearResult);
        }
    }

    private double roundResults (double value) {
        int scale = (int) Math.pow(10, 1);
        return (double) Math.round(value * scale) / scale;
    }
}
