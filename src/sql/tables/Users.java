package src.sql.tables;

public class Users extends Table {

    public Users() {
        super();
    }
    public void addRow (String role, String title, String forename, String surname, String username, String email) {
        super.addRow(new Object[] {role,title,forename,surname,username,email});
    }
}