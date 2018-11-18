package src.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.ui.admin.AdminUI;
import src.ui.login.Login;

public class MainWindow extends JFrame {

    Dimension screenSize;

    public MainWindow() {
        super("Main Window");

        Container contentPane = getContentPane();
        contentPane.add(new Login(this));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        setLocation(screenSize.width / 9, screenSize.height / 9);

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
        resetWindowSize();
    }

    public void resetWindowSize() {
        setSize((int) ((screenSize.width*3)/4), (int) ((screenSize.height*3)/4));
        //setLocation(screenSize.width / 8, screenSize.height / 8);
    }
    public static void main(String[] args) {
        new MainWindow();
    }
}