package src.sql.tables;
public class Departments extends Table {

    public Departments() {
        super();
    }
    public void addRow(String code, String name) {
        super.addRow(new Object[] {code, name});
    }
}