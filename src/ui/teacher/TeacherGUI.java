package src.ui.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.ui.MainWindow;

public class TeacherGUI extends JPanel {
    private JPanel editGrades;
    private JPanel teacherMainMenu;
    private JPanel registerStudent;
    private JPanel viewStudentInfo;
    private MainWindow mainWindow;
    private JButton logOffButton;

    public TeacherGUI(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        editGrades = new EditGrades(this);
        teacherMainMenu = new TeacherMainMenu(this);
        registerStudent = new RegisterStudent(this);
        viewStudentInfo = new ViewStudentInfo(this);
        logOffButton = new JButton();
        logOffButton.setText("Log Off");
        logOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainWindow.showLogInWindow();
            }
        });
        editGrades.setVisible(false);
        registerStudent.setVisible(false);
        viewStudentInfo.setVisible(false);
        placeComponents();

    }

    public JPanel getEditGrade() {
        return editGrades;
    }

    public JPanel getMainMenu() {
        return teacherMainMenu;
    }

    public JPanel getRegisterStudent() {
        return registerStudent;
    }

    public JPanel getStudentInfo() {
        return viewStudentInfo;
    }


    protected void placeComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOffButton)
                    .addComponent(teacherMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewStudentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(teacherMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewStudentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(logOffButton))
        );

        //pack();
    }
}
