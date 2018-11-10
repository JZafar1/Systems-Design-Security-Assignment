package src.ui.admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminUI extends JPanel {

    private JPanel adminMainMenu;
    private JPanel manageUserMenu;
    private JPanel manageDepartmentMenu;
    private JPanel manageDegreeMenu;
    private JPanel manageModuleMenu;
    private JPanel manageModuleLinksMenu;
    private JPanel manageDegreeLinksMenu;
    private JScrollPane databaseScrollPane;
    private JButton logOffButton;

    public AdminUI() {
        setVisible(true);
        initComponents();
    }
    /**
    *Initializes components in the JPanel
    */
    private void initComponents() {

        //initialise JPanels
        adminMainMenu = new AdminMainMenu(this);
        manageUserMenu = new ManageUserMenu(this);
        manageDepartmentMenu = new ManageDepartmentMenu(this);
        manageDegreeMenu = new ManageDegreeMenu(this);
        manageModuleMenu = new ManageModuleMenu(this);
        manageModuleLinksMenu = new ManageModuleLinksMenu(this);
        manageDegreeLinksMenu = new ManageDegreeLinksMenu(this);
        databaseScrollPane = new DatabaseScrollPane(this);

        logOffButton = new JButton();
        logOffButton.setText("Log Off");

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Administrator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));
        setFont(new java.awt.Font("Trebuchet MS", 0, 11));

        placeComponents();
    }

    public JPanel getMainMenu() {
        return adminMainMenu;
    }
    public JPanel getUserMenu() {
        return manageUserMenu;
    }
    public JPanel getDepartmentMenu() {
        return manageDepartmentMenu;
    }
    public JPanel getDegreeMenu() {
        return manageDegreeMenu;
    }
    public JPanel getModuleMenu() {
        return manageModuleMenu;
    }
    public JPanel getDegreeLinkMenu() {
        return manageDegreeLinksMenu;
    }
    public JPanel getModuleLinkMenu() {
        return manageModuleLinksMenu;
    }

    private void placeComponents() {

        javax.swing.GroupLayout adminUILayout = new javax.swing.GroupLayout(this);
            setLayout(adminUILayout);
            adminUILayout.setHorizontalGroup(
                adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adminUILayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(adminUILayout.createSequentialGroup()
                            .addComponent(logOffButton)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(adminUILayout.createSequentialGroup()
                            .addGroup(adminUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(manageDegreeLinksMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(databaseScrollPane)
                                .addComponent(manageModuleMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manageDepartmentMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manageUserMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(adminMainMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manageDegreeMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manageModuleLinksMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(16, 16, 16)
                .addComponent(manageDegreeLinksMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageModuleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageModuleLinksMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(databaseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logOffButton)
                .addContainerGap())
        );
    }
}
