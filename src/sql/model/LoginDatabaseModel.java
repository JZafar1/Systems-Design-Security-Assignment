package src.sql.model;

import java.sql.*;

public class LoginDatabaseModel extends DatabaseModel {

    public LoginDatabaseModel() {}

    public String getUser(String email, String password) {
        initConnection();
        initStatement();
        String role = null;
        try {
            try {
                openConnection();
                openStatement();
                openResultQuery("SELECT Role FROM Users WHERE Email='" + email + "' AND password='" + password + "';");
                while (getResult().next()) {
                    role = getResult().getString(1);
                }
            } finally {
                closeResultQuery();
                closeStatement();
                closeConnection();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return role;
    }
}