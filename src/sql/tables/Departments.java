package src.sql.tables;

import java.util.ArrayList;
public class Departments extends Table {

    public Departments() {
        super();
    }
    public void addRow(String code, String name) {
        super.addRow(new Object[] {code, name});
    }
    public String[] getDepartmentNames() {
        ArrayList<Object[]> table = getTableList();
        int rowNum = table.size();
        String[] departmentNames = new String[rowNum];
        for (int c = 0; c < rowNum; c++) {
            Object[] row = table.get(c);
            departmentNames[c] = (String) row[1];
        }
        return departmentNames;
    }
}