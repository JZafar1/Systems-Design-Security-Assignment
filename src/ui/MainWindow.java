package src.ui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.ui.admin.AdminUI;
import src.ui.login.Login;

public class MainWindow extends JFrame {

    private AdminUI adminWindow;
    private Login loginWindow;

    public MainWindow() {
        super("Main Window");

        loginWindow = new Login(this);
        adminWindow = new AdminUI();

        Container contentPane = getContentPane();
        contentPane.add(loginWindow);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    public void setUser(String role) {
        if (role.equals("Adminstrator")) {
            showAdminWindow();
            System.out.println(role);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid infomation!");
        }
    }

    public void showAdminWindow() {
        getContentPane().removeAll();
        getContentPane().add(adminWindow);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}