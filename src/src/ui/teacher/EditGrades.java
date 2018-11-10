package src.ui.teacher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditGrades extends Menu {
    private javax.swing.JLabel title;
    private javax.swing.JLabel select;
    private javax.swing.JLabel currentGradeLabel;
    private javax.swing.JLabel newGradeLabel;
    private javax.swing.JTextField currentGrade;
    private javax.swing.JTextField newGrade;
    private javax.swing.JButton submit;
    private javax.swing.JButton exitButton1;
    private javax.swing.JComboBox<String> moduleList;

    public EditGrades (TeacherGUI teacherui) {
        super(teacherui);
        setVisible(true);
        initComponents();
        placeComponents();
    }

    public void initComponents() {
        title = new JLabel();
        title.setText("Add or update grades");
        select = new JLabel();
        select.setText("Select Module");
        moduleList = new JComboBox();
        currentGradeLabel = new JLabel();
        currentGradeLabel.setText("Current Grade");
        currentGrade = new JTextField();
        currentGrade.setEditable(false);
        newGradeLabel = new JLabel();
        newGradeLabel.setText("Enter new grade");
        newGrade = new JTextField();
        submit = new JButton();
        exitButton1 = new JButton();
        moduleList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temp" })); //List to be generated from DB

        submit.setText("Save Changes");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commitChange();
            }
        });

        exitButton1.setText("Back");
        exitButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                getTeacherUI().getMainMenu().setVisible(true);
            }
        });
    }
    /* Method to take parameters representing changes to be made to DB and return true
    if the DB is successfully updated, flase otherwise*/
    public boolean commitChange() {
        return false;
    }

    protected void placeComponents() {
        javax.swing.GroupLayout editGradeLayout = new javax.swing.GroupLayout(this);
        setLayout(editGradeLayout);
        editGradeLayout.setHorizontalGroup(
            editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editGradeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitButton1)
                .addGap(18, 18, 18)
                .addComponent(submit))
            .addGroup(editGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentGrade)
                            .addComponent(newGrade)
                            .addComponent(moduleList, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        editGradeLayout.setVerticalGroup(
            editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(moduleList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentGradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editGradeLayout.createSequentialGroup()
                        .addComponent(newGradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(exitButton1)))
        );
    }
}
