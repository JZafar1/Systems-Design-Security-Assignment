package adminui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminUI extends JFrame {

    public AdminUI() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        initComponents();
    }
    /**
    *Initializes components in the JPanel
    */
    private void initComponents() {

        //initialise JPanels
        adminUI = new JPanel();
        adminMainMenu = new JPanel();
        manageUserMenu = new ManageUserMenu(adminMainMenu);
        manageDepartmentMenu = new ManageDepartmentMenu(adminMainMenu);
        manageDegreeMenu = new ManageDegreeMenu(adminMainMenu);
        manageModuleMenu = new ManageModuleMenu(adminMainMenu);
        databasePanel = new DatabasePanel(adminMainMenu);

        manageUserAccountsButton = new JButton();
        manageDepartmentsButton = new JButton();
        manageDegreesButton = new JButton();
        manageModulesButton = new JButton();
        logOffButton = new JButton();
        jLabel7 = new JLabel();
        databaseSelector = new JComboBox<>();

        adminUI.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Administrator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));
        adminUI.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        adminMainMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Choose infomation to show:");
        databaseSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Accounts (Staff)", 
            "User Accounts (Students)", "Departments", "Degrees", "Modules" }));

        manageUserAccountsButton.setText("Add User Account");
        manageUserAccountsButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showManageUserMenu();
            }
        });
        manageDepartmentsButton.setText("Add Department");
        manageDepartmentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showManageDepartmentMenu();
            }
        });
        manageDegreesButton.setText("Add Degree");
        manageDegreesButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showManageDegreeMenu();
            }
        });
        manageModulesButton.setText("Add Module");
        manageModulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showManageModuleMenu();
            }
        });
        logOffButton.setText("Log Off");
        placeComponents();
        pack();
    }

    private void showManageUserMenu() {
        adminMainMenu.setVisible(false);
        manageUserMenu.setVisible(true);
    }
    private void showManageDepartmentMenu() {
        adminMainMenu.setVisible(false);
        manageDepartmentMenu.setVisible(true);
    }
    private void showManageDegreeMenu() {
        adminMainMenu.setVisible(false);
        manageDegreeMenu.setVisible(true);
    }
    private void showManageModuleMenu() {
        adminMainMenu.setVisible(false);
        manageModuleMenu.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI();
            }
        });
    }

    private JPanel adminUI;
    private JPanel adminMainMenu;
    private JPanel manageUserMenu;
    private JPanel manageDepartmentMenu;
    private JPanel manageDegreeMenu;
    private JPanel manageModuleMenu;
    private JScrollPane databasePanel;
    private JButton logOffButton;
    private JButton manageUserAccountsButton;
    private JButton manageDepartmentsButton;
    private JButton manageDegreesButton;
    private JButton manageModulesButton;
    private JLabel jLabel7;
    private JComboBox<String> databaseSelector;

    private void placeComponents() {

      javax.swing.GroupLayout adminMainMenuLayout = new javax.swing.GroupLayout(adminMainMenu);
      adminMainMenu.setLayout(adminMainMenuLayout);
      adminMainMenuLayout.setHorizontalGroup(
          adminMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(adminMainMenuLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(adminMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(adminMainMenuLayout.createSequentialGroup()
                      .addComponent(manageUserAccountsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                      .addGap(1, 1, 1))
                  .addComponent(jLabel7))
              .addGap(5, 5, 5)
              .addGroup(adminMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(databaseSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(adminMainMenuLayout.createSequentialGroup()
                      .addComponent(manageDepartmentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(manageDegreesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                      .addComponent(manageModulesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
              .addGap(228, 228, 228))
      );
      adminMainMenuLayout.setVerticalGroup(
          adminMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(adminMainMenuLayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(adminMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(manageUserAccountsButton)
                  .addComponent(manageDepartmentsButton)
                  .addComponent(manageDegreesButton)
                  .addComponent(manageModulesButton))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(adminMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(databaseSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel7))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout adminUILayout = new javax.swing.GroupLayout(adminUI);
      adminUI.setLayout(adminUILayout);
      adminUILayout.setHorizontalGroup(
          adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(adminUILayout.createSequentialGroup()
              .addContainerGap()
              .addGroup(adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(databasePanel, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addGroup(adminUILayout.createSequentialGroup()
                      .addComponent(logOffButton)
                      .addGap(0, 0, Short.MAX_VALUE))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminUILayout.createSequentialGroup()
                      .addGroup(adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                          .addComponent(manageDepartmentMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(manageUserMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(adminMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(manageDegreeMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                          .addComponent(manageModuleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                      .addContainerGap())))
      );
      adminUILayout.setVerticalGroup(
          adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(adminUILayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(adminMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(manageUserMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(manageDepartmentMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(manageDegreeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(manageModuleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(databasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(logOffButton)
              .addContainerGap())
      );
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }
}
