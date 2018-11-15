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
    public Object[] getColumn(int columnNum) {
        int rowNum = tableList.size();
        Object[] columnValues = new String[rowNum];
    
        for (int c = 0; c < rowNum; c++) {
            Object[] row = tableList.get(c);
            columnValues[c] = row[columnNum];
        }
        return columnValues;
    } 
    public ArrayList<Object[]> getTableList() { return tableList; }
}