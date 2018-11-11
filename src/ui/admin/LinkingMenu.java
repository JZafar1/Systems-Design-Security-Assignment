package src.ui.admin;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class LinkingMenu extends Menu {

    protected class ChildTable extends JScrollPane {

        private JTable childTable;

        public ChildTable() {
            childTable = new JTable();
            childTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            setViewportView(childTable);
        }
    }

    private JButton addLinkButton;
    private JButton removeLinkButton;
    private JLabel selectParentLabel;
    private JLabel childTableLabel;
    private JComboBox<String> parentSelector;
    private ChildTable childSelectorTable;

    public LinkingMenu(AdminUI adminUI) {

        super(adminUI);
        
        addLinkButton = new JButton();
        removeLinkButton = new JButton();
        selectParentLabel = new JLabel();
        childTableLabel = new JLabel();
        parentSelector = new JComboBox<>();
        childSelectorTable = new ChildTable();
    }
    protected void setMenuTitle(String title) {
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), 
                        title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
    }
    protected void setAddLinkButtonText(String label) { addLinkButton.setText(label); }
    protected void setRemoveLinkButtonText(String label) { removeLinkButton.setText(label); }
    protected void setSelectParentLabelText(String label) { selectParentLabel.setText(label); }
    protected void setChildTableLabelText(String label) { childTableLabel.setText(label); }
    protected void setParentSelectorText(String[] list) {  parentSelector.setModel(new javax.swing.DefaultComboBoxModel<>(list)); } 

    protected JButton getAddLinkButton() { return addLinkButton; }
    protected JButton getRemoveLinkButton() { return removeLinkButton; }
    protected JLabel getSelectParentLabel() { return selectParentLabel; }
    protected JLabel getChildTableLabel() { return childTableLabel; }
    protected JComboBox getParentSelector() { return parentSelector; }
    protected ChildTable getChildSelectorTable() { return childSelectorTable; }

    protected abstract void placeComponents();
}