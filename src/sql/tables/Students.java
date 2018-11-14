package src.sql.tables;

import java.util.ArrayList;;

public class Students extends Table {

    public Students() {
        super();
    }
    public void addRow(String title, String forename, String surname, String username, String email, String regNum, String levelOfStudy, String grade, String degree, String tutor) {
        super.addRow(new Object[]  {regNum, title, forename, surname, username, email, 
                                    levelOfStudy, grade, degree, tutor});
    }
    public ArrayList<String> getStudentNames() {
        ArrayList<Object[]> table = getTableList();
        int rowNum = table.size();
        ArrayList<String> studentNames = new ArrayList<String>();
        for (int c = 0; c < rowNum; c++) {
            studentNames.add(((String) table.get(c)[1]) + " " +  ((String) table.get(c)[2]));
        }
        return studentNames;
    }
}