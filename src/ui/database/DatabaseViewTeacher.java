package src.ui.database;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import src.sql.controller.*;
import src.sql.model.AdminDatabaseModel;
import src.sql.tables.*;
import src.ui.teacher.TeacherGUI;
import java.util.ArrayList;
import java.sql.*;

public class DatabaseViewTeacher extends src.sql.model.DatabaseModel{

    private TeacherGUI teacherUI;
    private DatabaseViewController controller;

    public DatabaseViewTeacher() {
        controller = new DatabaseViewController();
    }

    public ArrayList<String> showModules() {
        initConnection();
        initStatement();
        ArrayList<String> results = new ArrayList<String>();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT * FROM Module;");
                while (getResult().next()) {
                    String res = getResult().getString(1) + " " + getResult().getString(2);
                    results.add(res);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public ArrayList<String> showStudents(String regNo) {
        ArrayList<String> students = new ArrayList<String>();
        try {
            try{
                openConnection();
                openStatement();
                openResultQuery("SELECT * FROM Student WHERE (Registration Number) = '"+ regNo + "'  JOIN Users USING (Username);");
                while (getResult().next()) {
                    String name = getResult().getString(12) + " " + getResult().getString(10);
                    students.add(name);
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
}
