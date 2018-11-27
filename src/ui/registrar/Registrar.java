package src.ui.registrar;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import src.sql.controller.RegistrarController;
import src.ui.database.DatabaseView;

public class Registrar extends JPanel {
    private javax.swing.JComboBox<String> dataSelect;
    private javax.swing.JTable finishedRegistration;
    private javax.swing.JTable inRegistration;
    private javax.swing.JPanel mainPanel;
    private DatabaseView registerScroll;
    private javax.swing.JButton registerStudent;
    private javax.swing.JLabel studentLabel;
    private DatabaseView studentViewScroll;
    private javax.swing.JButton registerButton;
    private RegistrarUI registrarUI;
    private RegistrarController controller;

    public Registrar(RegistrarUI registrarUI) {
        this.registrarUI = registrarUI;
        this.controller = new RegistrarController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        registerStudent = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        registerScroll = new DatabaseView(this);
        inRegistration = new javax.swing.JTable();
        studentViewScroll = new DatabaseView(this);
        finishedRegistration = new javax.swing.JTable();
        studentLabel = new javax.swing.JLabel();
        dataSelect = new JComboBox<>();
        studentLabel.setText("Select a student");
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

//        inRegistration.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
//        inRegistration.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//
//            },
//            new String [] {
//                "Title 1", "Title 2", "Title 3", "Title 4"
//            }
//        ));
//        registerScroll.setViewportView(inRegistration);
//
//        finishedRegistration.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
//        finishedRegistration.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//
//            },
//            new String [] {
//                "Title 1", "Title 2", "Title 3", "Title 4"
//            }
//        ));
//        studentViewScroll.setViewportView(finishedRegistration);

        registerScroll.showUnRegisterdStudents("2017");
        studentViewScroll.showRegisterdStudents("2017");
        dataSelect.setModel(new javax.swing.DefaultComboBoxModel<>(controller.getUnregisteredRegistrationNumbers("2017")));

        registerStudent.setText("Register Student");
        registerStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageModulesActionPerformed();
            }
        });
        registerButton.setText("Register a new student");
            registerButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    manageStudentActionPerformed();
                }
        });
        placeComponents();
    }

    private void manageStudentActionPerformed() {
        getRegistrarUI().showManageStudents();
    }

    private void manageModulesActionPerformed() {
        int recordId = controller.getRecordId(dataSelect.getSelectedItem().toString(),"2017");
        getRegistrarUI().showManageModules(recordId);
    }

    private RegistrarUI getRegistrarUI() { return registrarUI; }

    private void placeComponents() {
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerScroll)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(registerStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(studentViewScroll)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(studentLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dataSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataSelect)
                    .addComponent(studentLabel))
                .addGap(18, 18, 18)
                .addComponent(studentViewScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
}
