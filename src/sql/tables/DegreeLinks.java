package src.sql.tables;

public class DegreeLinks extends Table {

    public DegreeLinks() {
        super();
    }
    public void addRows(Int paringId, String departmentCode, String degreeCode) {
        super.addRow(new Object[] {paringId, departmentCode, degreeCode});
    }
}