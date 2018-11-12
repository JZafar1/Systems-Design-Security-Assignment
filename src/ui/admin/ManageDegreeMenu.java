package src.ui.admin;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.sql.controller.*;

public class ManageDegreeMenu extends Menu {

    private JLabel degreeNameLabel;
    private JLabel leadDepartmentLabel;
    private JLabel levelOfStudyLabel;
    private JLabel yearPlacementLabel;
    private JTextField degreeNameField;
    private JComboBox<String> leadDepartmentDropDown;
    private JComboBox<String> levelOfStudyDropDown;
    private JComboBox<String> yearPlacementDropDown;
    private JButton addDegreeButton;
    private JButton removeDegreeButton;
    private JButton manageDegreeLinksButton;
    private AdminController controller;

    public ManageDegreeMenu(AdminUI adminUI) {

        super(adminUI);

        degreeNameLabel = new JLabel();
        leadDepartmentLabel = new JLabel();
        levelOfStudyLabel = new JLabel();
        yearPlacementLabel = new JLabel();
        degreeNameField = new JTextField();
        leadDepartmentDropDown = new JComboBox<>();
        levelOfStudyDropDown = new JComboBox<>();
        yearPlacementDropDown = new JComboBox<>();
        addDegreeButton = new JButton();
        removeDegreeButton = new JButton();
        manageDegreeLinksButton = new JButton();

        controller = new AdminController();

        degreeNameLabel.setText("Degree Name: ");
        leadDepartmentLabel.setText("Lead Department: ");
        levelOfStudyLabel.setText("Level of Study: ");
        yearPlacementLabel.setText("Year Placement: ");
        leadDepartmentDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        levelOfStudyDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearPlacementDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addDegreeButton.setText("Add Degree");
        removeDegreeButton.setText("Remove Degree");
        manageDegreeLinksButton.setText("Manage Degree Links");
        manageDegreeLinksButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDegreeLinkMenu();
            }
        });


        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Degrees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
        placeComponents();
        
        addDegreeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addDegree(degreeNameField.getText(), (String)leadDepartmentDropDown.getSelectedItem(), (String)levelOfStudyDropDown.getSelectedItem() ,(String)yearPlacementDropDown .getSelectedItem());
            }
        });
        
        removeDegreeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.removeDegree((String)leadDepartmentDropDown.getSelectedItem());
            }
        });
        
    }
    private void showDegreeLinkMenu() {
        getAdminUI().getDegreeLinkMenu().setVisible(true);
        getAdminUI().getDegreeMenu().setVisible(false);
    }
    protected void placeComponents(){
        javax.swing.GroupLayout manageDegreeMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(manageDegreeMenuLayout);
        manageDegreeMenuLayout.setHorizontalGroup(
            manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDegreeMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageDegreeMenuLayout.createSequentialGroup()
                        .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(levelOfStudyLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(degreeNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(degreeNameField)
                            .addComponent(levelOfStudyDropDown, 0, 237, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearPlacementLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(leadDepartmentLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearPlacementDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leadDepartmentDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(manageDegreeMenuLayout.createSequentialGroup()
                        .addComponent(addDegreeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeDegreeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageDegreeLinksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manageDegreeMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addDegreeButton, backButton, manageDegreeLinksButton, removeDegreeButton});

        manageDegreeMenuLayout.setVerticalGroup(
            manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDegreeMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(degreeNameLabel)
                    .addComponent(degreeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leadDepartmentLabel)
                    .addComponent(leadDepartmentDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelOfStudyLabel)
                    .addComponent(levelOfStudyDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearPlacementLabel)
                    .addComponent(yearPlacementDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(manageDegreeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDegreeButton)
                    .addComponent(removeDegreeButton)
                    .addComponent(backButton)
                    .addComponent(manageDegreeLinksButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
