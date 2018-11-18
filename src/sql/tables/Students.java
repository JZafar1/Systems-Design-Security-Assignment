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
    
    public String[] getStudentNames() {
        int rowNum = getTableList().size();
        String[] studentNameList = new String[rowNum];
        for (int c = 0; c < rowNum; c++) {
            Object[] row = getTableList().get(c);
            studentNameList[c] = ((String) row[0]) + " " + ((String) row[1]);
        }
        return studentNameList;
    }
}