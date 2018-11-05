package adminui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class LinkingMenu extends Menu {

    private class ChildTable extends JScrollPane {

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

    protected void placeComponents() {
        javax.swing.GroupLayout linkingMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(linkingMenuLayout);
        linkingMenuLayout.setHorizontalGroup(
            linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(linkingMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(linkingMenuLayout.createSequentialGroup()
                        .addComponent(selectParentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parentSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(childTableLabel)
                    .addComponent(childSelectorTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(linkingMenuLayout.createSequentialGroup()
                        .addComponent(addLinkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeLinkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        linkingMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addLinkButton, backButton, removeLinkButton});
        linkingMenuLayout.setVerticalGroup(
            linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(linkingMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectParentLabel)
                    .addComponent(parentSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(childTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(childSelectorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addLinkButton)
                    .addComponent(removeLinkButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}