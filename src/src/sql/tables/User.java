package src.sql.tables;

public class User {

    String role;
    String title;
    String forename;
    String surname;
    String username;
    String email;

    public User(String role, String title, String forename, String surname, String username, String email) {
        this.role = role;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }
}