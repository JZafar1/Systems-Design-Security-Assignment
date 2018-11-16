package src.sql.model;

import java.sql.*;

import src.sql.tables.UserCredentials;

public class LoginDatabaseModel extends DatabaseModel {

    public LoginDatabaseModel() {}

    public UserCredentials getUserCredentials(String email) {
        initConnection();
        initStatement();
        UserCredentials userCredentials = new UserCredentials();
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT password, Role, Salt FROM Users WHERE Email='" + email + "';");
                while (getResult().next()) {
                    byte[] password = getResult().getBytes(1);
                    String role = getResult().getString(2);
                    byte[] salt = getResult().getBytes(3);
                    userCredentials.setCredentials(password, salt, role);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userCredentials;
    }
}