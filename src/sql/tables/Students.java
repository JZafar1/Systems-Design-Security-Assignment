package src.sql.tables;

public class Students extends Table {

    public Students() {
        super();
    }
    public void addRow(String title, String forename, String surname, String username, String email, String regNum, String levelOfStudy, String grade, String degree, String tutor) {
        super.addRow(new Object[]  {regNum, title, forename, surname, username, email, 
                                    levelOfStudy, grade, degree, tutor});
    }
}