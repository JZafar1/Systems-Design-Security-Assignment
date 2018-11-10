package src.sql.tables;

import java.util.ArrayList;

public class Departments {

    public class DepartmentRow {

        private Object[] row;
        
        public DepartmentRow (String code, String name){
            row = new Object[] {code, name};
        }
        public Object[] getRow() {
            return row;
        }
    }   
    
    private ArrayList<Object> departments;

    public Departments() {
        departments = new ArrayList<Object>();
    }
    public void addRow(String code, String name) {
        DepartmentRow newRow = new DepartmentRow(code, name);
        departments.add(newRow.getRow());
    }
    public Object[][] getDepartmentTable() {
        Object[][] departmentTable = new Object[departments.size()][];
        departmentTable = departments.toArray(departmentTable);
        return departmentTable;
    }
}