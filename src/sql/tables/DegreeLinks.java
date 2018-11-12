package src.sql.tables;

public class DegreeLinks extends Table {

    public DegreeLinks() {
        super();
    }
    public void addRows(int paringId, String departmentCode, String degreeCode) {
        super.addRow(new Object[] {paringId, departmentCode, degreeCode});
    }
}