package src.ui.registrar;

import javax.swing.JPanel;
public class Registrar extends JPanel {

    private javax.swing.JPanel displayArea;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextField infoField1;
    private javax.swing.JTextField infoField2;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton manageModules;
    private javax.swing.JButton manageStudent;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JPanel userArea;
    private RegistrarUI registrarUI;

    public Registrar(RegistrarUI registrarUI) {
        this.registrarUI = registrarUI;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        userArea = new javax.swing.JPanel();
        manageStudent = new javax.swing.JButton();
        manageModules = new javax.swing.JButton();
        infoField1 = new javax.swing.JTextField();
        infoField2 = new javax.swing.JTextField();
        displayArea = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        mainLabel = new javax.swing.JLabel();

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setName("Registrar"); // NOI18N

        userArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        manageStudent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        manageStudent.setText("Add or remove students");
        manageStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentActionPerformed();
            }
        });

        manageModules.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        manageModules.setText("Manage optional modules");
        manageModules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageModulesActionPerformed();
            }
        });

        infoField1.setFont(infoField1.getFont().deriveFont(infoField1.getFont().getSize()+1f));
        infoField1.setText("See a list of all students below to check the registration status of the student.");
        infoField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoField1ActionPerformed();
            }
        });

        infoField2.setFont(infoField2.getFont().deriveFont(infoField2.getFont().getSize()+1f));
        infoField2.setText("Click a students name to modify their chosen modules.");

        displayArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        displayTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
    
    private void manageStudentActionPerformed() {
        getRegistrarUI().showManageStudents();
    }

    private void manageModulesActionPerformed() {
        getRegistrarUI().showManageModules();
    }

    private void infoField1ActionPerformed() {
        // TODO add your handling code here:
    }
    private RegistrarUI getRegistrarUI() { return registrarUI; }

    private void placeComponents() {
        javax.swing.GroupLayout userAreaLayout = new javax.swing.GroupLayout(userArea);
        userArea.setLayout(userAreaLayout);
        userAreaLayout.setHorizontalGroup(userAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(userAreaLayout.createSequentialGroup().addContainerGap().addGroup(userAreaLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(infoField2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(infoField1, javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
                        .addGroup(userAreaLayout.createSequentialGroup()
                                .addComponent(manageStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18).addComponent(manageModules, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        userAreaLayout.setVerticalGroup(userAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(userAreaLayout.createSequentialGroup().addContainerGap()
                        .addGroup(userAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(manageStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(manageModules, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infoField2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)));

        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(displayAreaLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scrollTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE));
        displayAreaLayout.setVerticalGroup(displayAreaLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scrollTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(userArea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(mainLabel, javax.swing.GroupLayout.Alignment.LEADING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(displayArea, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userArea, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(displayArea,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)));
    }
}
