package src.sql.tables;

import java.util.ArrayList;
public class Modules extends Table {

    public Modules() {
        super();
    }
    public void addRow(String code, String name, String teachingDepartment) {
        super.addRow(new Object[] {code, name, teachingDepartment});
    }
    public String generateModuleCode(String departmentCode) {
        ArrayList<Object[]> moduleTable = getTableList();
        int rowNum = moduleTable.size();
        if (rowNum == 0) {
            return departmentCode.toUpperCase() + "0000";
        } else {
            String moduleCode = (String) moduleTable.get(rowNum - 1)[0];
            int code = Integer.parseInt(moduleCode.substring(3,7));
            return departmentCode + String.format("%04d", (code + 1));
        }
    }
}