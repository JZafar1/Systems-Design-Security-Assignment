package src.sql.tables;

public class ModuleLinks extends Table {

    public ModuleLinks() {
        super();
    }
    public void addRow(String degreeCode, String degreeName, String moduleCode, String moduleName, String level, String semester, String credits, String coreOrNot) {
        super.addRow(new Object[] {degreeCode, degreeName, moduleCode, moduleName, level, semester, credits, coreOrNot});
    }
    public Boolean occursInTable(String moduleCode, String degreeCode) {
        return super.occursInTable(moduleCode, 2) && super.occursInTable(degreeCode, 0);
    }
}