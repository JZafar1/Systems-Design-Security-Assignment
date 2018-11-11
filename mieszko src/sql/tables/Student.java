package src.sql.tables;

public class Student extends User {

    String regNum;
    String levelOfStudy;
    String grade;
    String degree;
    String tutor;

    public Student(String title, String forename, String surname, String username, String email, String regNum, String levelOfStudy, String grade, String degree, String tutor) {
        super("student", title, forename, surname, username, email);
        this.regNum = regNum;
        this.levelOfStudy = levelOfStudy;
        this.grade = grade;
        this.degree = degree;
        this.tutor = tutor;
    }
}