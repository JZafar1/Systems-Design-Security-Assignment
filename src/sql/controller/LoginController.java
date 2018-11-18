package src.sql.controller;

import java.util.Arrays;

import src.sql.model.LoginDatabaseModel;
import src.sql.tables.UserCredentials;

public class LoginController {

    private LoginDatabaseModel databaseModel;

    public LoginController() {
        databaseModel = new LoginDatabaseModel();
    }

    public String checkUser(String email, char[] passwordArray) {
        String password = String.valueOf(passwordArray);

        UserCredentials userCredentials = databaseModel.getUserCredentials(email);
        byte[] inputPassword = PasswordHasher.generateHashPassword(password, userCredentials.getSalt());

        if (Arrays.equals(inputPassword, userCredentials.getPasswordHash())) {
            return userCredentials.getRole();
        }
        return null;
    }
}