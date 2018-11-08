package TeacherGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherGUI extends JPanel {
    private JPanel editGrades;
    private JPanel teacherMainMenu;
    private JPanel registerStudent;
    private JPanel viewStudentInfo;
    private JButton logOffButton;

    public TeacherGUI() {
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        editGrades = new EditGrades(this);
        teacherMainMenu = new TeacherMainMenu(this);
        registerStudent = new RegisterStudent(this);
        logOffButton = new JButton();
        logOffButton.setText("Log Off");

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Administrator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));
        setFont(new java.awt.Font("Trebuchet MS", 0, 11));
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
        //return getStudentInfo;
        return null;
    }

}
