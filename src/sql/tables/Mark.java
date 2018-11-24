/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sql.tables;

/**
 *
 * @author aca17mss
 */
public class Mark extends Table {
    
    public Mark() {
        super();
    }
    public void addRow (int markId, String moduleCode, int recordId, int mark, int resitMark, String moduleName) {
        super.addRow(new Object[] {markId,moduleCode,recordId,mark,resitMark,moduleName});
    }
    
}
