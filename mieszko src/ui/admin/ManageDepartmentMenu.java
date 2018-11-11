package src.ui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import src.sql.controller.*;

public class ManageDepartmentMenu extends Menu {

    private JLabel departmentNameLabel;
    private JTextField departmentNameField;
    private JButton addDepartmentButton;
    private JButton removeDepartmentButton;

    public ManageDepartmentMenu(AdminUI adminUI) {

        super(adminUI);

        departmentNameLabel = new JLabel();
        departmentNameField = new JTextField();
        addDepartmentButton = new JButton();
        removeDepartmentButton = new JButton();
        

        departmentNameLabel.setText("Department Name: ");
        addDepartmentButton.setText("Add Department");
        removeDepartmentButton.setText("Remove Department");

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Departments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
        placeComponents();
        
        addDepartmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminController.addDepartment(departmentNameField.getText());
            }
        });
        
        //Added
        removeDepartmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminController.removeDepartment(departmentNameField.getText());
            }
        });
        
    }

    protected void placeComponents() {
        javax.swing.GroupLayout manageDepartmentMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(manageDepartmentMenuLayout);
        manageDepartmentMenuLayout.setHorizontalGroup(
            manageDepartmentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDepartmentMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageDepartmentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageDepartmentMenuLayout.createSequentialGroup()
                        .addComponent(departmentNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentNameField))
                    .addGroup(manageDepartmentMenuLayout.createSequentialGroup()
                        .addComponent(addDepartmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeDepartmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addGap(478, 478, 478))
        );
        manageDepartmentMenuLayout.setVerticalGroup(
            manageDepartmentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDepartmentMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageDepartmentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentNameLabel)
                    .addComponent(departmentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageDepartmentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addDepartmentButton)
                    .addComponent(removeDepartmentButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
