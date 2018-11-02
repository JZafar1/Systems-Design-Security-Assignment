package adminui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ManageModuleMenu extends Menu {

    private JLabel moduleNameLabel;
    private JLabel leadDepartmentLabel;
    private JTextField moduleNameField;
    private JComboBox<String> departmentComboBox;
    private JButton addModuleButton;
    private JButton removeModuleButton;

    public ManageModuleMenu(JPanel mainMenu) {

        super(mainMenu);

        moduleNameLabel = new JLabel();
        leadDepartmentLabel = new JLabel(); 
        moduleNameField = new JTextField();
        departmentComboBox = new JComboBox<>();
        addModuleButton = new JButton();
        removeModuleButton = new JButton();

        moduleNameLabel.setText("Module Name: ");
        leadDepartmentLabel.setText("Lead Department: ");
        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer Science", 
                                        "Software Engineering", "English", "Maths" }));
        addModuleButton.setText("Add Module");
        removeModuleButton.setText("Remove Module");

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
        placeComponents();
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
                        .addComponent(leadDepartmentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(169, 169, 169))
                    .addGroup(manageModuleMenuLayout.createSequentialGroup()
                        .addComponent(addModuleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeModuleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addGap(544, 544, 544))))
        );
        manageModuleMenuLayout.setVerticalGroup(
            manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageModuleMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduleNameLabel)
                    .addComponent(moduleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leadDepartmentLabel)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageModuleMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addModuleButton)
                    .addComponent(removeModuleButton))
                .addContainerGap())
        );

    }
}
