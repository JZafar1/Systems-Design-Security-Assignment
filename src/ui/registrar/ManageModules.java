package src.ui.registrar;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import src.sql.controller.RegistrarController;
import src.ui.database.DatabaseView;
public class ManageModules extends JPanel {

    private javax.swing.JPanel addRemoveModule;
    private javax.swing.JButton addModule;
    private javax.swing.JButton removeModule;
    private javax.swing.JButton complete;
    private javax.swing.JButton backButton;
    private javax.swing.JTable currentModuleTable;
    private DatabaseView moduleScroll;
    private javax.swing.JComboBox<String> optionalModuleList;
    private int recordId;
    private RegistrarController controller;


    private RegistrarUI registrarUI;
    private String registartionNumber;

    public ManageModules(RegistrarUI registrarUI, int recordId) {
        this.registrarUI = registrarUI;
        this.recordId = recordId;
        this.controller = new RegistrarController();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        addRemoveModule = new javax.swing.JPanel();
        addModule = new javax.swing.JButton();
        removeModule = new javax.swing.JButton();
        complete = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        currentModuleTable = new javax.swing.JTable();
        moduleScroll = new DatabaseView(this);
        optionalModuleList = new JComboBox<>();
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Manage Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 17)));

        currentModuleTable.setModel(new javax.swing.table.DefaultTableModel(
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
        moduleScroll.setViewportView(currentModuleTable);
        optionalModuleList.setModel(new javax.swing.DefaultComboBoxModel<>(controller.getOptionalModulesCodes(recordId,"2017")));
        addModule.setText("Add Module");
        addModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //do Something
                controller.addMark(recordId,optionalModuleList.getSelectedItem().toString());
                moduleScroll.showStudentsModules(recordId);
            }
        });

        removeModule.setText("Remove Module");
        removeModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TO DO
                controller.removeMark(moduleScroll.getSelectedRow(0));
                moduleScroll.showStudentsModules(recordId);
            }
        });

        complete.setText("Complete Registration");
        complete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TO DO
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        moduleScroll.showStudentsModules(recordId);
        
        placeComponents();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        getRegistrarUI().showRegistrarMenu();
    }

    private RegistrarUI getRegistrarUI() {
        return registrarUI;
    }
    private void placeComponents() {
        javax.swing.GroupLayout addRemoveModuleLayout = new javax.swing.GroupLayout(this);
            setLayout(addRemoveModuleLayout);
        addRemoveModuleLayout.setHorizontalGroup(
            addRemoveModuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRemoveModuleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addRemoveModuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addRemoveModuleLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(174, 174, 174)
                        .addComponent(complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addRemoveModuleLayout.createSequentialGroup()
                        .addComponent(optionalModuleList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72)
                        .addComponent(addModule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72)
                        .addComponent(removeModule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(moduleScroll, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        addRemoveModuleLayout.setVerticalGroup(
            addRemoveModuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addRemoveModuleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addRemoveModuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(addRemoveModuleLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(optionalModuleList))
                    .addComponent(addModule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeModule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(moduleScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRemoveModuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(complete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
}
