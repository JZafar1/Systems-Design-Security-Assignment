package src.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.ui.admin.AdminUI;
import src.ui.registrar.RegistrarUI;;
import src.ui.teacher.TeacherGUI;
import src.ui.student.StudentUI;
import src.ui.login.Login;

public class MainWindow extends JFrame {

    Dimension screenSize;

    public MainWindow() {
        super("Main Window");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        showLogInWindow();
        setLocation((int) (screenSize.width * 0.05), (int) (screenSize.height * 0.05));
        setPreferredSize(new Dimension( (int) (screenSize.width * 0.94), (int) (screenSize.height * 0.8)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    public void setUser(String[] userInfo) {
        String role = userInfo[0];
        String username = userInfo[1];
        if (role != null) {
            switch(role) {
                case "Adminstrator":
                    showAdminWindow(username);
                    System.out.println("Connected to database");
                    break;
                case "Teacher":
                    showTeacherWindow(username);
                    System.out.println("Connected to database");
                    break;
                case "Registrar":
                    showRegistrarWindow(username);
                    System.out.println("Connected to database");
                    break;
                case "Student":
                    showStudentWindow(username);
                    System.out.println("Connected to database");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid infomation!");
        }
    }

    public void showLogInWindow() {
        getContentPane().removeAll();
        getContentPane().add(new Login(this));
        pack();
    }
    public void showTeacherWindow(String username) {
        getContentPane().removeAll();
        getContentPane().add(new TeacherGUI(this, username));
        pack();
    }
    public void showAdminWindow(String username) {
        getContentPane().removeAll();
        getContentPane().add(new AdminUI(this, username));
        pack();
    }
    public void showRegistrarWindow(String username) {
        getContentPane().removeAll();
        getContentPane().add(new RegistrarUI(this, username));
        pack();
    }
    public void showStudentWindow(String username) {
        getContentPane().removeAll();
        getContentPane().add(new StudentUI(this, username));
        pack();
    }
}