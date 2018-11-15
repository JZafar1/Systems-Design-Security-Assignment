package src.sql.controller;

import src.sql.model.LoginDatabaseModel;

public class LoginController {

    private LoginDatabaseModel databaseModel;

    public LoginController() {
        databaseModel = new LoginDatabaseModel();
    }

    public String checkUser(String email, String password) {
        String role = databaseModel.getUser(email, password);
        return role;
    }
}