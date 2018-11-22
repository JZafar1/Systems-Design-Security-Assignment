package src.ui.database;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import src.sql.controller.*;
import src.sql.model.AdminDatabaseModel;
import src.sql.tables.*;

import src.ui.admin.AdminUI;

public class DatabaseView extends JScrollPane{

    private AdminUI adminUI;
    private JTable databaseTable;
    private DatabaseViewController controller;

    public DatabaseView(AdminUI adminUI) {

        this.adminUI = adminUI;
        controller = new DatabaseViewController();
        databaseTable = new JTable();

        databaseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        showDepartments();
    }

    public void switchDatabase(String tableName) {
        switch (tableName) {
            case "User Accounts (Staff)" : 
                showUsers();
                break;
            case "User Accounts (Students)":
                showStudents();
                break;
            case "Departments":
                showDepartments();
                break;
            case "Degrees":
                showDegrees();
                break;
            case "Modules":
                showModules();
                break;
            default:
                showUsers();
        }
    }
    
    public void showDepartments() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getDepartments(),
                        new String[] { "Department Code", "Department Name"}));
        setViewportView(databaseTable);
    }
    
    public void showDegrees() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getDegrees(),
                new String[] { "Degree Code", "Degree Name", "Level of Study", "Lead Department"}));
        setViewportView(databaseTable);
    }
    
    public void showModules() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getModules(),
                new String[] { "Module Code", "Module Name", "Teaching Department"}));
        setViewportView(databaseTable);
    }
    public void showUsers() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getUsers(),
                new String[] { "User Role", "Title", "Forename", "Surname", "Username", "Email"}));
        setViewportView(databaseTable);
    }
    
    public void showStudents() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getStudents(),
                new String[] {"Registration Number", "Title", "Forename", "Surname", "Username", 
                                "Email", "Level of Study", "Grade", "Degree", "Tutor"}));
        setViewportView(databaseTable);
    }

    public void showDegreeLinks() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getDegreeLinks(),
                new String[] {"Degree Code", "Degree Name", "Department Code", "Department Name"}));
        setViewportView(databaseTable);
    }

    public void showModuleLinks() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getModuleLinks(),
                new String[] { "Degree Code", "Degree Name", "Module Code", "Module Name", "Level", "Semester", "Credits", "Core or Not"}));
        setViewportView(databaseTable);
    }

    /**
     * Returns selected field in the selected row
     * @param col - col index of selected row you want to return
     * @return
     */
    public String getSelectedRow(int col) { 
        int row = databaseTable.getSelectedRow();
        if (row == -1)
            return null;
        return databaseTable.getModel().getValueAt(row, col).toString();
     }
}