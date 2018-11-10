package src.ui.admin;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import src.sql.controller.*;
import src.sql.model.AdminDatabaseModel;
import src.sql.tables.*;

public class DatabaseView extends JScrollPane{

    private AdminUI adminUI;
    private JTable databaseTable;
    private DatabaseViewController controller;

    public DatabaseView(AdminUI adminUI) {

        this.adminUI = adminUI;
        controller = new DatabaseViewController();
        databaseTable = new JTable();

        showDepartments();
    }

    public void switchDatabase(String tableName) {
        showDepartments();
        System.out.println(tableName);
    }

    private void showDepartments() {
        databaseTable.setModel(new javax.swing.table.DefaultTableModel(controller.getDepartments(),
                        new String[] { "Department Code", "Department Name"}));
        setViewportView(databaseTable);
    }
}