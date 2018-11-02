package adminui;

import javax.swing.*;

public class ManageUserMenu extends JPanel {

    private JPanel mainMenu;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField forenameField;
    private JTextField surnameField;
    private JComboBox<String> roleSelector;
    private JButton addUserButton;
    private JButton removeUserButton;
    private JButton backButton;

    public ManageUserMenu(JPanel mainMenu) {

        this.mainMenu = mainMenu;

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        forenameField = new JTextField();
        surnameField = new JTextField();
        roleSelector = new JComboBox<>();
        addUserButton = new JButton();
        removeUserButton = new JButton();
        backButton = new JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage User Accounts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));

        jLabel1.setText("Forename: ");
        jLabel2.setText("Surname: ");
        jLabel3.setText("Role: ");

        addUserButton.setText("Add User");
        removeUserButton.setText("Remove User");
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideManageUserMenu(evt);
            }
        });
        roleSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Adminstrator", "Registrar", "Teacher" }));

        placeComponents();
        setVisible(false);
    }

    public void hideManageUserMenu(java.awt.event.ActionEvent evt) {
        setVisible(false);
        mainMenu.setVisible(true);
    }

    public void placeComponents() {

      javax.swing.GroupLayout manageUserMenuLayout = new javax.swing.GroupLayout(this);
      setLayout(manageUserMenuLayout);
      manageUserMenuLayout.setHorizontalGroup(
          manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(manageUserMenuLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(manageUserMenuLayout.createSequentialGroup()
                      .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
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
              .addComponent(jLabel2)
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
                  .addComponent(jLabel1)
                  .addComponent(forenameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel2)
                  .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(manageUserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel3)
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
