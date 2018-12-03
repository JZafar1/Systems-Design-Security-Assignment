package src.sql.controller;

import java.util.Arrays;

import src.sql.model.LoginDatabaseModel;
import src.sql.tables.UserCredentials;

/**
 * Controller for the login system, that handles the
 * logic of validating username and passwords against the 
 * database.
 */
public class LoginController {

    private LoginDatabaseModel databaseModel;
    private SQLValidation validation;

    public LoginController() {
        databaseModel = new LoginDatabaseModel();
        validation = new SQLValidation();
    }

    public String[] checkUser(String email, char[] passwordArray) {
        
        email = validation.generalValidation(email);
        
        String password = String.valueOf(passwordArray);

        UserCredentials userCredentials = databaseModel.getUserCredentials(email);
        byte[] inputPassword = PasswordHasher.generateHashPassword(password, userCredentials.getSalt());

        if (Arrays.equals(inputPassword, userCredentials.getPasswordHash())) {
            return userCredentials.getUserInfo();
        }
        return null;
    }
}