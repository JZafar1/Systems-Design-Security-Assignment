package src.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.ui.admin.AdminUI;
import src.ui.login.Login;

public class MainWindow extends JFrame {

    public MainWindow() {
        super("Main Window");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setLocation(screenSize.width/4, screenSize.height/4);

        Container contentPane = getContentPane();
        contentPane.add(new Login(this));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
    public void setUser(String role) {
        if (role != null && role.equals("Adminstrator")) {
            showAdminWindow();
            System.out.println(role);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid infomation!");
        }
    }

    public void showAdminWindow() {
        getContentPane().removeAll();
        getContentPane().add(new AdminUI());
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}