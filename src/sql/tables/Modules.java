package src.sql.tables;

public class Modules extends Table {

    public Modules() {
        super();
    }
    public void addRow(String code, String name, String teachingDepartment) {
        super.addRow(new Object[] {code, name, teachingDepartment});
    }
}