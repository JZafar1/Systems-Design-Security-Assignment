package src.ui.teacher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.sql.controller.TeacherController;
import java.util.ArrayList;

public class EditGrades extends Menu {
    private javax.swing.JLabel select;
    private javax.swing.JLabel currentGradeLabel;
    private javax.swing.JLabel selectLabel;
    private javax.swing.JLabel newGradeLabel;
    private javax.swing.JLabel currentStudentLabel;
    private javax.swing.JTextField currentGrade;
    private javax.swing.JTextField newGrade;
    private javax.swing.JTextField currentStudent;
    private javax.swing.JButton submit;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> moduleList;
    private javax.swing.JComboBox<String> studentList;
    private TeacherController controller;

    public EditGrades (TeacherGUI teacherui) {
        super(teacherui);
        controller = new TeacherController();
        setVisible(true);
        initComponents();
        placeComponents();
    }

    public void initComponents() {
        select = new JLabel();
        select.setText("Select Module");
        moduleList = new JComboBox<String>();
        currentGradeLabel = new JLabel();
        currentGradeLabel.setText("Current Grade");
        currentGrade = new JTextField();
        currentGrade.setText("null");
        currentGrade.setEditable(false);
        newGradeLabel = new JLabel();
        newGradeLabel.setText("Enter new grade");
        newGrade = new JTextField();
        submit = new JButton();
        currentStudentLabel = new JLabel();
        currentStudentLabel.setText("Student Name");
        currentStudent = new JTextField();
        currentStudent.setText("Student Name");
        currentStudent.setEditable(false);
        selectLabel = new JLabel();
        selectLabel.setText("Select Student");
        studentList = new JComboBox<String>();
        backButton = new JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Add or Update Grades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));

        submit.setText("Save Changes");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commitChange();
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getTeacherUI().getMainMenu().setVisible(true);
            }
        });
        displayModule();
        displayStudents();

        studentList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    //Do Something
                }
            }
        });

        moduleList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    getCurrentGrade();
                }
            }
        });
    }

    private void displayModule() {
        moduleList.setModel(new javax.swing.DefaultComboBoxModel<String>(controller.getModuleNames()));
    }

    private void displayStudents() {
        String[] stuList = controller.getStudents();
        studentList.setModel(new DefaultComboBoxModel(stuList));
    }

    private void getCurrentGrade() {

    }

    public boolean commitChange() {
        return false;
    }

    protected void placeComponents() {
        javax.swing.GroupLayout editGradeLayout = new javax.swing.GroupLayout(this);
        setLayout(editGradeLayout);
        editGradeLayout.setHorizontalGroup(
            editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGradeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editGradeLayout.createSequentialGroup()
                        .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(select, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)))
                .addGap(18, 18, 18)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addComponent(studentList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(currentGrade)
                    .addComponent(newGrade)
                    .addComponent(moduleList, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
            .addGroup(editGradeLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        editGradeLayout.setVerticalGroup(
            editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editGradeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(studentList))
                    .addComponent(selectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(moduleList))
                    .addComponent(select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(currentGrade)))
                .addGap(18, 18, 18)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newGrade)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(newGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
}
