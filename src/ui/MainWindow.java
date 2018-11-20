package src.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.ui.admin.AdminUI;
import src.ui.teacher.TeacherGUI;
import src.ui.login.Login;

public class MainWindow extends JFrame {

    Dimension screenSize;

    public MainWindow() {
        super("Main Window");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        showLogInWindow();
        setLocation(screenSize.width / 9, screenSize.height / 9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    public void setUser(String role) {
        if (role != null) {
            switch(role) {
                case "Adminstrator":
                    showAdminWindow();
                    System.out.println("Connected to database");
                    break;
                case "Teacher":
                    showTeacherWindow();
                    System.out.println("Connected to database");
                    break;
                case "Registrar":
                    showRegistrarWindow();
                    System.out.println("Connected to database");
                    break;
                default:
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
    public void showTeacherWindow() {
        getContentPane().removeAll();
        getContentPane().add(new TeacherGUI(this));
        pack();
    }
    public void showAdminWindow() {
        getContentPane().removeAll();
        getContentPane().add(new AdminUI(this));
        pack();
    }
    public void showRegistrarWindow() {
        System.out.println("showRegistrarWindow method is called");
    }

}