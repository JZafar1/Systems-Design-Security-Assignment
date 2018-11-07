package src.ui.admin;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.*;

public class ManageModuleMenu extends Menu {

    private JLabel moduleNameLabel;
    private JLabel leadDegreeLabel;
    private JTextField moduleNameField;
    private JComboBox<String> departmentComboBox;
    private JButton addModuleButton;
    private JButton removeModuleButton;
    private JButton manageModuleLinks;

    public ManageModuleMenu(AdminUI adminUI) {

        super(adminUI);

        moduleNameLabel = new JLabel();
        leadDegreeLabel = new JLabel(); 
        moduleNameField = new JTextField();
        departmentComboBox = new JComboBox<>();
        addModuleButton = new JButton();
        removeModuleButton = new JButton();
        manageModuleLinks = new JButton();

        moduleNameLabel.setText("Module Name: ");
        leadDegreeLabel.setText("Lead Degree: ");
        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", 
                                        "Software Engineering", "English", "Maths" }));
        addModuleButton.setText("Add Module");
        removeModuleButton.setText("Remove Module");

        manageModuleLinks.setText("Manage Module Links");
        manageModuleLinks.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showModuleLinkMenu();
            }
        });

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
        placeComponents();
    }
    private void showModuleLinkMenu() {
        getAdminUI().getModuleLinkMenu().setVisible(true);
        getAdminUI().getModuleMenu().setVisible(false);
    }
    protected void placeComponents() {
        javax.swing.GroupLayout manageModuleMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(manageModuleMenuLayout);
        manageModuleMenuLayout.setHorizontalGroup(
            manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageModuleMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageModuleMenuLayout.createSequentialGroup()
                        .addComponent(moduleNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moduleNameField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(leadDegreeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(manageModuleMenuLayout.createSequentialGroup()
                        .addComponent(addModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeModuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manageModuleLinks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        manageModuleMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addModuleButton, backButton, manageModuleLinks, removeModuleButton});
        manageModuleMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {departmentComboBox, moduleNameField});

        manageModuleMenuLayout.setVerticalGroup(
            manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageModuleMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduleNameLabel)
                    .addComponent(moduleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leadDegreeLabel)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addModuleButton)
                    .addComponent(removeModuleButton)
                    .addComponent(manageModuleLinks))
                .addContainerGap())
        );

    }
}
