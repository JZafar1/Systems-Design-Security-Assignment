package src.ui.registrar;

import javax.swing.JPanel;
public class ManageModules extends JPanel {

    private javax.swing.JButton addModuleButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField moduleCode;
    private javax.swing.JLabel moduleLabel;
    private javax.swing.JLabel regNoLabel;
    private javax.swing.JButton removeModuleButton;
    private javax.swing.JPanel resultsArea;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTextField studentRegNo;
    private javax.swing.JPanel userPanel;
    private RegistrarUI registrarUI;

    public ManageModules(RegistrarUI registrarUI) {
        this.registrarUI = registrarUI;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        addModuleButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        removeModuleButton = new javax.swing.JButton();
        moduleLabel = new javax.swing.JLabel();
        moduleCode = new javax.swing.JTextField();
        regNoLabel = new javax.swing.JLabel();
        studentRegNo = new javax.swing.JTextField();
        resultsArea = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        mainLabel = new javax.swing.JLabel();

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setName("Registrar"); // NOI18N

        userPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addModuleButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addModuleButton.setText("Add Selected Module");

        backButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        removeModuleButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        removeModuleButton.setText("Drop Selected Module");

        moduleLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        moduleLabel.setText("Module Code");

        moduleCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleCodeActionPerformed(evt);
            }
        });

        regNoLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        regNoLabel.setText("Student registration number");

        studentRegNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRegNoActionPerformed(evt);
            }
        });

        resultsArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        displayTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollTable.setViewportView(displayTable);

        mainLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        mainLabel.setText("Registrar");

        placeComponents();
    }

    private void moduleCodeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        getRegistrarUI().showRegistrarMenu();
    }
    private void studentRegNoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private RegistrarUI getRegistrarUI() {
        return registrarUI;
    }
    private void placeComponents() {
        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(userPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(userPanelLayout.createSequentialGroup().addContainerGap().addGroup(userPanelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(userPanelLayout.createSequentialGroup()
                                .addComponent(moduleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(moduleCode))
                        .addComponent(addModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(userPanelLayout.createSequentialGroup().addGap(18, 18, 18)
                                        .addComponent(removeModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18).addComponent(backButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        userPanelLayout.createSequentialGroup().addGap(25, 25, 25)
                                                .addComponent(regNoLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18,
                                                        Short.MAX_VALUE)
                                                .addComponent(studentRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 198,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        userPanelLayout.setVerticalGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(moduleLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(moduleCode, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(regNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(studentRegNo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(removeModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)));

        javax.swing.GroupLayout resultsAreaLayout = new javax.swing.GroupLayout(resultsArea);
        resultsArea.setLayout(resultsAreaLayout);
        resultsAreaLayout
                .setHorizontalGroup(resultsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultsAreaLayout.createSequentialGroup().addComponent(scrollTable,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        resultsAreaLayout.setVerticalGroup(resultsAreaLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scrollTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(resultsArea, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(userPanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(resultsArea, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
    }
}
