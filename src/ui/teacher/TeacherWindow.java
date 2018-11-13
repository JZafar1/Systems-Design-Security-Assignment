package src.ui.teacher;
import javax.swing.*;

public class TeacherWindow extends JFrame {

    private JPanel teacherGUI;

    public TeacherWindow() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        initComponents();
    }
    private void initComponents() {
        teacherGUI = new TeacherGUI();
        placeComponents();
    }

    protected void placeComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(teacherGUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teacherGUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TeacherWindow().setVisible(true);
        });
    }
}
