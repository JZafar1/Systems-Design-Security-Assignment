package adminui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ManageModuleLinksMenu extends Menu {

    private class DegreeTable extends JScrollPane {

        private JTable  degreeTable;

        public DegreeTable() {
            degreeTable = new JTable();
            degreeTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            setViewportView(degreeTable);
        }
    }

    private JButton addModuleLinkButton;
    private JButton backButton;
    private JLabel selectModuleLabel;
    private JLabel degreeTableLabel;
    private JComboBox<String> moduleSelector;
    private DegreeTable degreeSelectorTable;

    public ManageModuleLinksMenu(AdminUI adminUI) {
        
        super(adminUI);

        addModuleLinkButton = new JButton();
        backButton = new JButton();
        selectModuleLabel = new JLabel();
        degreeTableLabel = new JLabel();
        moduleSelector = new JComboBox<>();
        degreeSelectorTable = new DegreeTable();

        addModuleLinkButton.setText("Add Module Link");
        backButton.setText("Remove Module Link");
        selectModuleLabel.setText("Select Module: ");
        degreeTableLabel.setText("Select Degree(s) to add from table: ");
        moduleSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", 
                                                                                        "Item 3", "Item 4" }));
        placeComponents();
    }
    protected void placeComponents() {
        javax.swing.GroupLayout manageModuleLinksMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(manageModuleLinksMenuLayout);
        manageModuleLinksMenuLayout.setHorizontalGroup(
            manageModuleLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageModuleLinksMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageModuleLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(manageModuleLinksMenuLayout.createSequentialGroup()
                        .addComponent(selectModuleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moduleSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(degreeTableLabel)
                    .addComponent(degreeSelectorTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(manageModuleLinksMenuLayout.createSequentialGroup()
                        .addComponent(addModuleLinkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manageModuleLinksMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addModuleLinkButton, backButton});

        manageModuleLinksMenuLayout.setVerticalGroup(
            manageModuleLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageModuleLinksMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageModuleLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectModuleLabel)
                    .addComponent(moduleSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degreeTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(degreeSelectorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageModuleLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addModuleLinkButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}