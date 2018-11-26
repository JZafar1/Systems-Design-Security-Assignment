package src.sql.model;
import src.sql.tables.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDatabaseModel extends DatabaseModel {

    public TeacherDatabaseModel() {}

    public String getTutor(String condition) {
        initConnection();
        initStatement();
        String results = "";
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT Tutor FROM Student " + condition);
                while (getResult().next()) {
                    results = getResult().getString(1);
                }

            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public String getDegreeName(String condition) {
        initConnection();
        initStatement();
        String results = "";
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT Degree_DegreeCode FROM  Student WHERE `Registration number` = '"
                    + condition + "';");
                while (getResult().next()) {
                    results = getResult().getString(1);
                }
                String query = "WHERE DegreeCode = '" + results + "';";
                openResultQuery("SELECT `Degree name` FROM Degree " + query);
                while (getResult().next()) {
                    results = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public String getDegreeName(String regNo, String moduleCode) {
        initConnection();
        initStatement();
        String results = "";
        try {
            try {
                openConnection();
                openStatement();
                String query = "WHERE `Student_Registration number` = '" + regNo + "';";
                String record = getRecordId(query);
                openConnection();
                openStatement();
                query = "WHERE `Record_Record ID` = '" + results +
                "' AND Module_ModuleCode = '" + moduleCode + "';";
                openResultQuery("SELECT `The mark` FROM Mark " + query);
                while (getResult().next()) {
                    results = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public String getRecordId(String cond) {
        initConnection();
        initStatement();
        String result = "";
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT `Record ID` FROM  Record " + cond);
                while (getResult().next()) {
                    result = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void insertGrade(String name, String module, String grade) {
        initConnection();
        initStatement();
        String theModule = module.substring(0, 7);
        try {
            try {
                openConnection();
                openStatement();
                String query = "WHERE `Student_Registration number` = '" + name + "';";
                String record = getRecordId(query);
                String tables = "Mark (`The mark`) ";
                String values = "('" + grade + "') WHERE "
                    + "`Record_Record ID` = '" + record + "' AND "
                    + "Module_ModuleCode = '" + theModule + "'";
                insertIntoDatabase(tables, values);
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
