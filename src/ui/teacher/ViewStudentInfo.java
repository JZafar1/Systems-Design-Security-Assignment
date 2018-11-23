package src.ui.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.sql.controller.TeacherController;

public class ViewStudentInfo extends Menu{
    private javax.swing.JLabel selStu;
    private javax.swing.JLabel foreNameLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel regNoLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel studyLabel;
    private javax.swing.JLabel degreeLabel;
    private javax.swing.JLabel tutorLabel;
    private javax.swing.JTextField forename;
    private javax.swing.JTextField surname;
    private javax.swing.JTextField resgistrationNumber;
    private javax.swing.JTextField email;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField studyLevel;
    private javax.swing.JTextField degree;
    private javax.swing.JTextField tutor;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> studentList;
    private TeacherController controller;

    public ViewStudentInfo (TeacherGUI teacherui) {
        super(teacherui);
        controller = new TeacherController();
        setVisible(true);
        initComponents();
        placeComponents();
    }

    public void initComponents() {
        selStu = new javax.swing.JLabel();
        studentList = new javax.swing.JComboBox<String>();
        foreNameLabel = new javax.swing.JLabel();
        forename = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        regNoLabel = new javax.swing.JLabel();
        resgistrationNumber = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        studyLabel = new javax.swing.JLabel();
        studyLevel = new javax.swing.JTextField();
        degreeLabel = new javax.swing.JLabel();
        degree = new javax.swing.JTextField();
        tutorLabel = new javax.swing.JLabel();
        tutor = new javax.swing.JTextField();
        selStu.setText("Select student to view");
        foreNameLabel.setText("Forename");
        forename.setText("(Text)");
        surnameLabel.setText("Surname");
        surname.setText("(Text)");
        regNoLabel.setText("Registration Number");
        resgistrationNumber.setText("(Text)");
        emailLabel.setText("E-Mail Addressl");
        email.setText("(Text)");
        userNameLabel.setText("User Name");
        userName.setText("(Text)");
        studyLabel.setText("Study Level");
        studyLevel.setText("(Text)");
        degreeLabel.setText("Degree Title");
        degree.setText("(Text)");
        tutorLabel.setText("Tutor");
        tutor.setText("(Text)");

        backButton = new javax.swing.JButton();
        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getTeacherUI().getMainMenu().setVisible(true);
            }
        });

        studentList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    displayInformation(String.valueOf(studentList.getSelectedItem()));
                }
            }
        });

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));
        displayStudents();
    }

    private void displayStudents() {
        String[] stuList = controller.getStudents();
        studentList.setModel(new DefaultComboBoxModel(stuList));
    }

    private void displayInformation(String name) {
        String cond = "WHERE First Name = '" + name.substring(0, name.indexOf(' '))  + "'";
        String [] theResults = controller.getStudentInfo(cond);
    }

    protected void placeComponents() {
        javax.swing.GroupLayout viewStudentInfoLayout = new javax.swing.GroupLayout(this);
        setLayout(viewStudentInfoLayout);
        viewStudentInfoLayout.setHorizontalGroup(
            viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentInfoLayout.createSequentialGroup()
                        .addComponent(regNoLabel)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                                .addComponent(forename, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                                .addComponent(resgistrationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentInfoLayout.createSequentialGroup()
                        .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentInfoLayout.createSequentialGroup()
                                .addComponent(degreeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(viewStudentInfoLayout.createSequentialGroup()
                                        .addComponent(studyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(studyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewStudentInfoLayout.createSequentialGroup()
                                        .addComponent(tutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tutor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(viewStudentInfoLayout.createSequentialGroup()
                        .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selStu)
                            .addComponent(foreNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        viewStudentInfoLayout.setVerticalGroup(
            viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStudentInfoLayout.createSequentialGroup()
                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selStu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foreNameLabel)
                    .addComponent(forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoLabel)
                    .addComponent(resgistrationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameLabel)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studyLabel)
                    .addComponent(studyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(degreeLabel)
                    .addGroup(viewStudentInfoLayout.createSequentialGroup()
                        .addGroup(viewStudentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tutorLabel)
                            .addComponent(tutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(backButton))))
        );
    }
}
