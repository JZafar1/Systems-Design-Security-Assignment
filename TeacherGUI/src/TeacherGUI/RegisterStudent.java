package TeacherGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class RegisterStudent extends Menu{
    private javax.swing.JLabel registerTitle;
    private javax.swing.JLabel weightedMeanLabel;
    private javax.swing.JLabel finalResultLabel;
    private javax.swing.JTextField weightedMean;
    private javax.swing.JTextField finalResult;
    private javax.swing.JButton register;


    public RegisterStudent (TeacherGUI teacherui) {
        super(teacherui);
        setVisible(true);
        initComponents();
        placeComponents();
    }

    public void initComponents() {
        registerTitle = new javax.swing.JLabel();
        registerTitle.setText("Register a student for the next period of study");
        weightedMeanLabel = new javax.swing.JLabel();
        weightedMeanLabel.setText("Weighted mean for current period");
        weightedMean = new javax.swing.JTextField();
        weightedMean.setEditable(false);
        finalResultLabel = new javax.swing.JLabel();
        finalResultLabel.setText("Final result for this period");
        finalResult = new javax.swing.JTextField();
        finalResult.setEditable(false);
        register = new javax.swing.JButton();
        register.setText("Register Student");
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerNewStudent();
            }
        });
    }

    public void registerNewStudent() {

    }
    public void placeComponents() {
        javax.swing.GroupLayout registerStudentLayout = new javax.swing.GroupLayout(this);
                setLayout(registerStudentLayout);
                registerStudentLayout.setHorizontalGroup(
                    registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registerStudentLayout.createSequentialGroup()
                                .addComponent(finalResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(register))
                            .addGroup(registerStudentLayout.createSequentialGroup()
                                .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerTitle)
                                    .addGroup(registerStudentLayout.createSequentialGroup()
                                        .addComponent(weightedMeanLabel)
                                        .addGap(34, 34, 34)
                                        .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(weightedMean, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                            .addComponent(finalResult))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                );
                registerStudentLayout.setVerticalGroup(
                    registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerTitle)
                        .addGap(18, 18, 18)
                        .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(weightedMeanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(weightedMean))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(finalResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerStudentLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(register)
                        .addContainerGap())
                );
    }
}
