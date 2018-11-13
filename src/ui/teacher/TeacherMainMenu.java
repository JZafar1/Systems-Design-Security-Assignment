package src.ui.teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.ui.database.DatabaseViewTeacher;
import java.util.ArrayList;

public class TeacherMainMenu extends Menu {
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel currentlySelectedLabel;
    private javax.swing.JTextField searchQuery;
    private javax.swing.JTextField currentlySelected;
    private javax.swing.JButton editGrades;
    private javax.swing.JButton registerStudent;
    private javax.swing.JButton viewResults;
    private javax.swing.JComboBox studentList;
    private DatabaseViewTeacher dbView;

    public TeacherMainMenu (TeacherGUI teacherui) {
        super(teacherui);
        setVisible(true);
        initComponents();
        placeComponents();
        dbView = new DatabaseViewTeacher();
    }

    private void initComponents() {
        searchLabel = new JLabel();
        searchLabel.setText("Select Student");
        studentList = new javax.swing.JComboBox<>();
        studentList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentlySelectedLabel = new JLabel();
        currentlySelectedLabel.setText("Current Student");
        currentlySelected = new JTextField();
        currentlySelected.setEditable(false);
        editGrades = new JButton();
        registerStudent = new JButton();
        viewResults = new JButton();

        studentList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    currentlySelected.setText(String.valueOf(studentList.getSelectedItem()));
                }
            }
        });

        editGrades.setText("Add or Update Grades");
        editGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editGradesMenu();
            }
        });
        registerStudent.setText("Register student for next period of study");
        registerStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudentMenu();
            }
        });
        viewResults.setText("View student results & information");
        viewResults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudentInfo();
            }
        });
        displayStudents();
    }

    private void displayStudents() {
        ArrayList<String> stuList = dbView.getStudents();
        studentList.setModel(new DefaultComboBoxModel(stuList.toArray()));

    }

    private void editGradesMenu() {
        setVisible(false);
        getTeacherUI().getEditGrade().setVisible(true);
    }

    private void registerStudentMenu() {
        setVisible(false);
        getTeacherUI().getRegisterStudent().setVisible(true);
    }

    private void viewStudentInfo() {
        setVisible(false);
        getTeacherUI().getStudentInfo().setVisible(true);
    }

    protected void placeComponents() {
        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(18, 18, 18)
                        .addComponent(studentList, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(currentlySelectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(currentlySelected, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(editGrades)
                        .addGap(18, 18, 18)
                        .addComponent(registerStudent)
                        .addGap(18, 18, 18)
                        .addComponent(viewResults)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentlySelectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currentlySelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editGrades)
                    .addComponent(registerStudent)
                    .addComponent(viewResults))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
