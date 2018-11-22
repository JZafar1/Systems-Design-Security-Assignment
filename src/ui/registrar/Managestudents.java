package src.ui.registrar;

import javax.swing.JPanel;

public class ManageStudents extends JPanel {

    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField degreeName;
    private javax.swing.JLabel degreeNameLabel;
    private javax.swing.JPanel displayArea;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField otherName;
    private javax.swing.JLabel otherNameLabel;
    private javax.swing.JButton removeStudentButton;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JPanel userPanel;
    private RegistrarUI registrarUI;
    private javax.swing.JButton logOffButton;

    public ManageStudents(RegistrarUI registrarUI) {
        this.registrarUI = registrarUI;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        userPanel = new javax.swing.JPanel();
        addStudentButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        removeStudentButton = new javax.swing.JButton();
        otherNameLabel = new javax.swing.JLabel();
        otherName = new javax.swing.JTextField();
        degreeName = new javax.swing.JTextField();
        degreeNameLabel = new javax.swing.JLabel();
        displayArea = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        mainLabel = new javax.swing.JLabel();
        logOffButton = new javax.swing.JButton();
        userPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addStudentButton.setFont(new java.awt.Font("Arial", 0, 14));
        addStudentButton.setText("Add Student");

        backButton.setFont(new java.awt.Font("Arial", 0, 14));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Arial", 1, 18));
        mainLabel.setText("Registrar");

        logOffButton.setText("Sign Out");
        logOffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOffButtonActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Arial", 0, 18));
        firstNameLabel.setText("First Name");

        lastNameLabel.setFont(new java.awt.Font("Arial", 0, 18));
        lastNameLabel.setText("Last Name");

        removeStudentButton.setFont(new java.awt.Font("Arial", 0, 14));
        removeStudentButton.setText("Remove Selected Student");
        removeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentButtonActionPerformed(evt);
            }
        });

        otherNameLabel.setFont(new java.awt.Font("Arial", 0, 18));
        otherNameLabel.setText("Other Names");

        degreeNameLabel.setFont(new java.awt.Font("Arial", 0, 18));
        degreeNameLabel.setText("Degreee Name");

        displayTable.setFont(new java.awt.Font("Arial", 0, 18));
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

    private RegistrarUI getRegistrarUI() {
        return registrarUI;
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        getRegistrarUI().showRegistrarMenu();
    }

    private void removeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void logOffButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void placeComponents() {
        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userPanelLayout.createSequentialGroup()
                                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(degreeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(degreeName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(userPanelLayout.createSequentialGroup()
                                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(otherNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(otherName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(removeStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(firstName))
                    .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(otherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(otherName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(degreeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(degreeName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        displayArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTable)
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayAreaLayout.createSequentialGroup()
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

}
