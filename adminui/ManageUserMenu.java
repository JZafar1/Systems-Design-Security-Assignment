package adminui;

import javax.swing.*;

public class ManageUserMenu extends Menu {

    private JLabel forenameLabel;
    private JLabel surnameLabel;
    private JLabel roleLabel;
    private JTextField forenameField;
    private JTextField surnameField;
    private JComboBox<String> roleSelector;
    private JButton addUserButton;
    private JButton removeUserButton;

    public ManageUserMenu(JPanel mainMenu) {

        super(mainMenu);

        forenameLabel = new JLabel();
        surnameLabel = new JLabel();
        roleLabel = new JLabel();
        forenameField = new JTextField();
        surnameField = new JTextField();
        roleSelector = new JComboBox<>();
        addUserButton = new JButton();
        removeUserButton = new JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage User Accounts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));

        forenameLabel.setText("Forename: ");
        surnameLabel.setText("Surname: ");
        roleLabel.setText("Role: ");

        addUserButton.setText("Add User");
        removeUserButton.setText("Remove User");
        roleSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Adminstrator", "Registrar", "Teacher" }));

        placeComponents();
        setVisible(false);
    }

    protected void placeComponents() {

      javax.swing.GroupLayout manageUserMenuLayout = new javax.swing.GroupLayout(this);
      setLayout(manageUserMenuLayout);
      manageUserMenuLayout.setHorizontalGroup(
          manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(manageUserMenuLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(manageUserMenuLayout.createSequentialGroup()
                      .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addComponent(roleLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(forenameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addComponent(roleSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addComponent(forenameField, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addGroup(manageUserMenuLayout.createSequentialGroup()
                      .addComponent(addUserButton)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(removeUserButton)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(surnameLabel)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      manageUserMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {forenameField, roleSelector, surnameField});

      manageUserMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addUserButton, backButton, removeUserButton});

      manageUserMenuLayout.setVerticalGroup(
          manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(manageUserMenuLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(forenameLabel)
                  .addComponent(forenameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(surnameLabel)
                  .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(roleLabel)
                  .addComponent(roleSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(addUserButton)
                  .addComponent(removeUserButton)
                  .addComponent(backButton))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
    }
}
