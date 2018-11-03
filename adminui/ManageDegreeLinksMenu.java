package adminui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageDegreeLinksMenu extends Menu {

    private class DepartmentTable extends JScrollPane {

        private JTable  departmentTable;

        public DepartmentTable() {
            departmentTable = new JTable();
            departmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
            setViewportView(departmentTable);
        }
    }

    private JButton addDegreeLinkButton;
    private JButton removeDegreeLinkButton;
    private JLabel selectDegreeLabel;
    private JLabel departmentTableLabel;
    private JComboBox<String> departmentSelector;
    private DepartmentTable departmentSelectorTable;

    public ManageDegreeLinksMenu(AdminUI adminUI) {
        
        super(adminUI);

        addDegreeLinkButton = new JButton();
        removeDegreeLinkButton = new JButton();
        selectDegreeLabel = new JLabel();
        departmentTableLabel = new JLabel();
        departmentSelector = new JComboBox<>();
        departmentSelectorTable = new DepartmentTable();

        setBackButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                getAdminUI().getDegreeMenu().setVisible(true);
            }
        });

        addDegreeLinkButton.setText("Add Degree Link");
        removeDegreeLinkButton.setText("Remove Degree Link");
        selectDegreeLabel.setText("Select Degree: ");
        departmentTableLabel.setText("Select Departments(s) to add from table: ");
        departmentSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", 
                                                                                        "Item 3", "Item 4" }));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), 
                                                                "Manage Degrees Links", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                                                                    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
        placeComponents();
    }
    protected void placeComponents() {
        javax.swing.GroupLayout manageDegreeLinksMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(manageDegreeLinksMenuLayout);
        manageDegreeLinksMenuLayout.setHorizontalGroup(
            manageDegreeLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDegreeLinksMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageDegreeLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(manageDegreeLinksMenuLayout.createSequentialGroup()
                        .addComponent(selectDegreeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(departmentTableLabel)
                    .addComponent(departmentSelectorTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(manageDegreeLinksMenuLayout.createSequentialGroup()
                        .addComponent(addDegreeLinkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeDegreeLinkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manageDegreeLinksMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addDegreeLinkButton, backButton, removeDegreeLinkButton});

        manageDegreeLinksMenuLayout.setVerticalGroup(
            manageDegreeLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDegreeLinksMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageDegreeLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectDegreeLabel)
                    .addComponent(departmentSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departmentTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departmentSelectorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageDegreeLinksMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addDegreeLinkButton)
                    .addComponent(removeDegreeLinkButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}