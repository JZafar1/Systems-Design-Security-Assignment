package src.ui.manager;

import src.ui.admin.AdminWindow;

public class LoginManager {

    public LoginManager() {}

    public void showAdminWindow() {
        
        AdminWindow adminWindow = new AdminWindow();
    }

    public static void main(String[] args) {

        LoginManager loginManager = new LoginManager();
        loginManager.showAdminWindow();
    }
}