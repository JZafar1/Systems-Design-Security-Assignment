package src.sql.controller;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import src.sql.controller.*;
import src.sql.model.TeacherDatabaseModel;
import src.sql.controller.RegistrarController;
import src.sql.tables.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherController {

    private TeacherDatabaseModel teacherDatabaseModel;
    private RegistrarController registrarController;

    public TeacherController() {
        teacherDatabaseModel = new TeacherDatabaseModel();
        registrarController = new RegistrarController();
    }

    //Get full list of modules and module codes
    public String[] getModuleNames() {
        Modules modules = teacherDatabaseModel.getModules("*", "");
        String[] moduleNames = modules.getModuleNames();
        if (moduleNames == null || moduleNames.length == 0) {
            return new String[] {"No modules found"};
        } else {
            return moduleNames;
        }
    }

    public String[] getStudents() {
        Students students = teacherDatabaseModel.getStudents("*", "");
        return students.getStudentNames();
    }

    //All student information
    public String [] studentInfo(String cond) {
        Students theStudent = teacherDatabaseModel.getStudents("*", cond);
        return theStudent.getStudentInformation();
    }

    public String getStudentTutor(String cond) {
        return teacherDatabaseModel.getTutor(cond);
    }

    public String[] getModuleList(String student) {
        String record = getRecordId(student);
        ArrayList<String> tempArray = teacherDatabaseModel.getStudentModuleCode(record);
        String[] stringArray = new String[tempArray.size()];
        for(int i=0;i<tempArray.size();i++) stringArray[i] = tempArray.get(i);
        return stringArray;
    }

    public String getDegreeName(String cond) {
        return teacherDatabaseModel.getDegreeName(cond);
    }

    //Get grade for a given module
    public String getGrade(String cond, String module, String resit) {
        return teacherDatabaseModel.getCurrentGrade(cond, module, resit);
    }

    public void updateGrade(String student, String module, String grade, boolean resit) {
        teacherDatabaseModel.insertGrade(student, module, grade, resit);
    }

    public void createPassStudent(String student) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        String query = "UPDATE Record SET Registered = 'No' WHERE "
            + "`Student_Registration number` = '" + student + "' AND "
            + "`Period of study_Label` = '" + currentYear + "';";
        teacherDatabaseModel.updateQuery(query);
        updateLevelOfStudy(student);
        updatePeriodOfStudy(student);
    }

    public void createFailStudent(String student) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        String query = "UPDATE Record SET Registered = 'Failed' WHERE "
            + "`Student_Registration number` = '" + student + "' AND "
            + "`Period of study_Label` = '" + currentYear + "';";
        teacherDatabaseModel.updateQuery(query);
        updatePeriodOfStudy(student);
    }

    public void createResitStudent(String student) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        String query = "UPDATE Record SET Registered = 'Resit' WHERE "
            + "`Student_Registration number` = '" + student + "' AND "
            + "`Period of study_Label` = '" + currentYear + "';";
        teacherDatabaseModel.updateQuery(query);
        updatePeriodOfStudy(student);
    }

    public void graduateSudent(String student) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        String query = "UPDATE Record SET Registered = 'Graduated' WHERE "
            + "`Student_Registration number` = '" + student + "' AND "
            + "`Period of study_Label` = '" + currentYear + "';";
        teacherDatabaseModel.updateQuery(query);
    }

    public String createPeriodOfStudy(String student, String period) {
        registrarController.registerStudent(student, period);
        return null;
    }

    public void updateLevelOfStudy(String student) {
        int currentLevel = getLevelOfStudy(student);
        String query = "UPDATE Student SET `Level of study` = '" + (currentLevel + 1)
            + "' WHERE `Registration number` = '" + student + "';";
        teacherDatabaseModel.updateQuery(query);
    }

    public void updatePeriodOfStudy(String student) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        if(!checkPeriodOfStudy(currentYear)) {
            createPeriodOfStudy(currentYear);
        }else {
            String query = "UPDATE Record SET `Period of study_Label` = '" + (currentYear + 1)
                + "' WHERE `Student_Registration number` = '" + student + "';";
            teacherDatabaseModel.updateQuery(query);
        }
    }

    public boolean checkPeriodOfStudy(int period) {
        String query = "SELECT * FROM `Period of study` WHERE `Label` = '" + (period + 1) + "';";
        return teacherDatabaseModel.executeBoolQuery(query);
    }

    public void createPeriodOfStudy(int period) {
        String table = "`Period of study`";
        String start = "01.09." + (period + 1);
        String end = "01.07." + (period + 1);
        String values = "('" + (period + 1) + "','" + start + "','" + end + "')";
        teacherDatabaseModel.insertIntoDatabase(table, values);
    }

    public String theDegreeResult(String student) {
        String initialResult = getDegreeResult(student);
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
        allGrades = teacherDatabaseModel.getGradeList(student);
        if(initialResult.equalsIgnoreCase("fail")) {
            System.out.println("Dupa1");
            if(getLevelOfStudy(student) != 4) {
                int creditsEarned = creditsAchieved(student);
                if(checkMinCreditsReq(student) && creditsAchieved(student) != 120
                    && modulesPassed(student) == (numberOfModules(student) - 1) ) {
                    return "Conceded Pass";
                }else {
                    return "Fail";
                }
            }else if(getDegreeType(student).equalsIgnoreCase("One Year Msc")) {
                return postgradResult(student);
            }else {
                int creditsEarned = creditsAchieved(student);
                if(checkMinCreditsReq(student) && creditsAchieved(student) != 180
                    && modulesPassed(student) == (numberOfModules(student) - 1)) {
                    return "Conceded Pass";
                }else {
                    return studentFailed(student);
                }
            }
        }else {
            System.out.println("Dupa2");
            if(creditsAchieved(student) == 120) {
                return initialResult;
            }else if(creditsAchieved(student) <= 100 &&
                modulesPassed(student) == (numberOfModules(student) - 1)) {
                int minGrade = allGrades.indexOf(Collections.min(allGrades));
                if(minGrade > 29.5) {
                    return "Conceded Pass";
                }
            }
        }
        return "Error";
    }

    public String postgradResult(String student) {
        int credits = creditsAchieved(student);
        int dissertation = checkDissertationGrade(student);
        if(dissertation == 1) {
            ArrayList<Integer> allGrades = new ArrayList<Integer>();
            allGrades = teacherDatabaseModel.getGradeList(student);
            int minGrade = allGrades.indexOf(Collections.min(allGrades));
            if(creditsAchieved(student) == 180) {
                return "Proceed to graduation";
            }else if(minGrade >= 49.5 && creditsAchieved(student) >= 165) {
                return "Graduate with bachelors";
            }else if(minGrade >= 39.5) {
                return "Achieved Postgraduate Diploma";
            }else {
                return "Fail";
            }
        }else if(dissertation == 0) {
            if(creditsAchieved(student) >= 120) {
                return "Acheieved Postgraduate Ceritificate";
            }else {
                return "Fail";
            }
        }else {
            return "Fail";
        }
    }

    //Calculate the degree result for a given year
    public String getDegreeResult(String student) {
        final double theMeanGrade = getWeightedMean(student);
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
        if(theGrade < 39.5) {
            return "Fail";
        }else if(theGrade <= 44.4) {
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

    public String studentFailed(String name) {
        String type = getDegreeType(name);
        int level = getLevelOfStudy(name);
        if(level == 3 && type.equalsIgnoreCase("Bsc")
            || type.equalsIgnoreCase("Msc")) {
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

    public double getWeightedMean(String student) {
        double weightedMean = 0;
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
        ArrayList<Integer> theModules = new ArrayList<Integer>();
        allGrades = teacherDatabaseModel.getGradeList(student);
        theModules = getCreditValue(student);
        double divisor = 0;
        if(getLevelOfStudy(student) == 4) {
            divisor = 180;
        }else{
            divisor = 120;
        }
        for(int i = 0; i < allGrades.size(); i++) {
            weightedMean += (allGrades.get(i) * (theModules.get(i) / divisor));
        }
        updateWeightedMean(student, roundResults(weightedMean));
        return roundResults(weightedMean);
    }

    //Get a list of all periods of study
    public ArrayList<Integer> getPeriodsofStudy(String student) {
            String query = "SELECT `Period of study_Label` FROM Record WHERE "
                    + "`Student_Registration number` = '" + student + "';";
        ArrayList<String> results = new ArrayList<String>();
        results = teacherDatabaseModel.getPeriodOfStudy(query);
        ArrayList<Integer> resultAsInt = new ArrayList<Integer>(results.size()) ;
        for (String temp : results) {
            resultAsInt.add(Integer.valueOf(temp));
        }
        return resultAsInt;
    }

    //Add weighted mean to database
    public void updateWeightedMean(String student, double mean) {
        ArrayList<Integer> periods = getPeriodsofStudy(student);
        int currentYear = Collections.max(periods);
        String query = "UPDATE Record SET Average = '" + mean + "' WHERE "
            + "`Period of study_Label` = '" + currentYear + "';";
    }

    public ArrayList<Integer> getCreditValue(String student) {
        String record = getRecordId(student);
        ArrayList<String> moduleCodes = new ArrayList<String>();
        moduleCodes = teacherDatabaseModel.getStudentModuleCode(record);
        ArrayList<Integer> creditValues = new ArrayList<Integer>();
        for(int i = 0; i < moduleCodes.size(); i++) {
            creditValues.add(teacherDatabaseModel.getCredits(student, moduleCodes.get(i)));
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
        if(checkMinGradeReq(student)) {
            return false;
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
        int grade = Integer.parseInt(teacherDatabaseModel.getCurrentGrade(student, theModule, "false"));
        if(grade >= 49.5) {
            return 1;
        }else {
            if(creditsAchieved(student) >= 60) {
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
        if(getLevelOfStudy(student) == 3) {
            double totalAverage = (thisYearResult * (2/3)) + (lastYearResult * (1/3));
            totalAverage = roundResults(totalAverage);
            return getBachelorResult(totalAverage);
        }else if(getLevelOfStudy(student) == 4) {
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

    public int modulesPassed(String student) {
        ArrayList<Integer> credits = new ArrayList<Integer>();
        credits = getCreditValue(student);
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
        allGrades = teacherDatabaseModel.getGradeList(student);
        int total = 0;
        for(int i = 0; i < allGrades.size(); i++) {
            if(getLevelOfStudy(student) != 4) {
                if(allGrades.get(i) >= 39.5) {
                    total ++;
                }
            }else {
                if(allGrades.get(i) >= 49.5) {
                    total++;
                }
            }
        }
        return total;
    }

    public int numberOfModules(String student) {
        ArrayList<Integer> allGrades = new ArrayList<Integer>();
         return (teacherDatabaseModel.getGradeList(student).size());

    }

    private double roundResults (double value) {
        int scale = (int) Math.pow(10, 1);
        return (double) Math.round(value * scale) / scale;
    }
}
