package src.sql.tables;

public class UserCredentials {

    private byte[] passwordHash;
    private byte[] salt;
    private String role;

    public UserCredentials() {}

    public void setCredentials(byte[] password, byte[] salt, String role) {
        this.passwordHash = password;
        this.salt = salt;
        this.role = role;
    }
    public byte[] getPasswordHash() { return passwordHash; }
    public byte[] getSalt() { return salt; }
    public String getRole() { return role; }
    public Boolean isNull() { return role==null; }
}