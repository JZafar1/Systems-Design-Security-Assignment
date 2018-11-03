package adminui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

public class DatabaseScrollPane extends JScrollPane{

    private AdminUI adminUI;
    private JTable databaseTable;

    public DatabaseScrollPane(AdminUI adminUI) {

        this.adminUI = adminUI;
        databaseTable = new JTable();

        databaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {false, null, null, null},
                {false, null, null, null},
                {false, null, null, null},
                {false, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        setViewportView(databaseTable);
    }
}