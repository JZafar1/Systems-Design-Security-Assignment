package src.sql.tables;

public class DegreeLinks extends Table {

    public DegreeLinks() {
        super();
    }
    public void addRow(int paringId, String departmentCode, String degreeCode) {
        super.addRow(new Object[] {paringId, departmentCode, degreeCode});
    }
}