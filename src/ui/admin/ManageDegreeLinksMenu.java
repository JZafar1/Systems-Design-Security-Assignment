package src.ui.admin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import src.sql.controller.AdminController;

public class ManageDegreeLinksMenu extends LinkingMenu {

        private AdminController controller;

    public ManageDegreeLinksMenu(AdminUI adminUI) {
        
        super(adminUI);

        controller = new AdminController();

        setAddLinkButtonText("Add Degree Link");
        setRemoveLinkButtonText("Remove Degree Link");
        setSelectParentLabelText("Select Degree: ");
        setChildTableLabelText("Select Departments(s) to add from table: ");
        setMenuTitle("Manage Degrees Links");
        setParentSelectorText(controller.getDegreeNames());
        
        getChildSelectorTable().showDepartments();

        setBackButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                getAdminUI().getDegreeMenu().setVisible(true);
            }
        });

        placeComponents();
    }
    protected void placeComponents() {
        javax.swing.GroupLayout linkingMenuLayout = new javax.swing.GroupLayout(this);
        setLayout(linkingMenuLayout);
        linkingMenuLayout.setHorizontalGroup(linkingMenuLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(linkingMenuLayout.createSequentialGroup().addContainerGap().addGroup(linkingMenuLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(linkingMenuLayout.createSequentialGroup().addComponent(getSelectParentLabel())
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getParentSelector(), 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(getChildTableLabel())
                        .addComponent(getChildSelectorTable(), javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(linkingMenuLayout.createSequentialGroup().addComponent(getAddLinkButton())
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getRemoveLinkButton())
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        linkingMenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] { getAddLinkButton(), backButton, getRemoveLinkButton() });
        linkingMenuLayout.setVerticalGroup(linkingMenuLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(linkingMenuLayout.createSequentialGroup().addContainerGap()
                        .addGroup(linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(getSelectParentLabel()).addComponent(getParentSelector(),
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getChildTableLabel())
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getChildSelectorTable(), javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(linkingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(backButton).addComponent(getAddLinkButton()).addComponent(getRemoveLinkButton()))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }
}