package src.ui.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.sql.controller.TeacherController;


public class RegisterStudent extends Menu{
    private javax.swing.JLabel weightedMeanLabel;
    private javax.swing.JLabel finalResultLabel;
    private javax.swing.JLabel selectStuLabel;
    private javax.swing.JTextField weightedMean;
    private javax.swing.JTextField finalResult;
    private javax.swing.JButton register;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> students;
    private TeacherController controller;

    public RegisterStudent (TeacherGUI teacherui) {
        super(teacherui);
        controller = new TeacherController();
        setVisible(true);
        initComponents();
        placeComponents();
    }

    public void initComponents() {
        selectStuLabel = new JLabel();
        selectStuLabel.setText("Select a student");
        weightedMeanLabel = new javax.swing.JLabel();
        weightedMeanLabel.setText("Weighted mean for current period");
        weightedMean = new javax.swing.JTextField();
        weightedMean.setEditable(false);
        finalResultLabel = new javax.swing.JLabel();
        finalResultLabel.setText("Final result for this period");
        finalResult = new javax.swing.JTextField();
        finalResult.setEditable(false);
        students = new JComboBox<String>();

        register = new javax.swing.JButton();
        register.setText("Register Student");
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerNewStudent();
            }
        });

        backButton = new javax.swing.JButton();
        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getTeacherUI().getMainMenu().setVisible(true);
            }
        });

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Register student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));
        displayStudents();
    }

    private void displayStudents() {
        String[] stuList = controller.getStudents();
        students.setModel(new DefaultComboBoxModel(stuList));
    }

    public void registerNewStudent() {

    }

    protected void placeComponents() {
        javax.swing.GroupLayout registerStudentLayout = new javax.swing.GroupLayout(this);
        setLayout(registerStudentLayout);
        registerStudentLayout.setHorizontalGroup(
            registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addComponent(finalResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addGap(96, 96, 96))
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weightedMeanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectStuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weightedMean, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(finalResult)
                            .addComponent(students, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(39, 39, 39))
            .addGroup(registerStudentLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        registerStudentLayout.setVerticalGroup(
            registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerStudentLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(selectStuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(students))
                .addGap(18, 18, 18)
                .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(weightedMean)
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addComponent(weightedMeanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(finalResult)))
                .addGap(18, 18, 18)
                .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
}
