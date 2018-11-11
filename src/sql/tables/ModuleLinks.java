package src.sql.tables;

public class ModuleLinks extends Table {

    public ModuleLinks() {
        super();
    }
    public void addRow(Int pairingId, String moduleCode, String degreeCode, String degreeLevel, String season, String credits) {
        super.addRow(new Object[] {pairingId, moduleCode, degreeCode, degreeLevel, season, credits});
    }
}