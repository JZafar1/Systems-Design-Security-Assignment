package src.sql.controller;

import java.util.Arrays;

import src.sql.model.LoginDatabaseModel;
import src.sql.tables.UserCredentials;

public class LoginController {

    private LoginDatabaseModel databaseModel;

    public LoginController() {
        databaseModel = new LoginDatabaseModel();
    }

    public String checkUser(String email, String password) {
        UserCredentials userCredentials = databaseModel.getUserCredentials(email);
        byte[] inputPassword = PasswordHasher.generateHashPassword(password, userCredentials.getSalt());

        //System.out.println(inputPassword);
        System.out.println(userCredentials.getPasswordHash());

        if (Arrays.equals(inputPassword, userCredentials.getPasswordHash())) {
            return userCredentials.getRole();
        }
        return null;
    }
}