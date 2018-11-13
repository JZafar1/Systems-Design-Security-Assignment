package src.sql.tables;

import java.util.ArrayList;

public abstract class Table {

    private ArrayList<Object[]> tableList;

    public Table() {
        tableList = new ArrayList<Object[]>();
    }
    public void addRow(Object[] row) {
        tableList.add(row);
    }
    public Object[][] getTable() {
        Object[][] table = new Object[tableList.size()][];
        table = tableList.toArray(table);
        return table;
    }
    public ArrayList<Object[]> getTableList() { return tableList; }
}