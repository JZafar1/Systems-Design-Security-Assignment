package src.ui.admin;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import src.sql.controller.AdminController;

public class ManageModuleLinksMenu extends LinkingMenu {

    private JLabel degreeLevelLabel;
    private JLabel seasonLabel;
    private JLabel creditsLabel;
    private JLabel coreLabel;
    private JComboBox<String> degreeLevelDropDown;
    private JComboBox<String> seasonDropDown;
    private JComboBox<String> coreDropDown;
    private JTextField creditsField;
    private AdminController controller;

    public ManageModuleLinksMenu(AdminUI adminUI) {

        super(adminUI);

        controller = new AdminController();

        setAddLinkButtonText("Add Module Link");
        setRemoveLinkButtonText("Remove Module Link");
        setSelectParentLabelText("Select Module: ");
        setChildTableLabelText("Select Degree(s) to add from table: ");
        setMenuTitle("Manage Module Links");
        setParentSelectorText(controller.getModuleNames());

        degreeLevelLabel = new JLabel();
        seasonLabel = new JLabel();
        creditsLabel = new JLabel();
        coreLabel = new JLabel();
        degreeLevelDropDown = new JComboBox<>();
        seasonDropDown = new JComboBox<>();
        coreDropDown = new JComboBox<>();
        creditsField = new JTextField();

        refreshDatabaseView();

        degreeLevelLabel.setText("Degree Level: ");
        seasonLabel.setText("Season: ");
        creditsLabel.setText("Credits: ");
        degreeLevelDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Level 1", "Level 2", "Level 3","Level 4"}));
        seasonDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autumn", "Spring"}));
        coreDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Core", "Not Core"}));

        setBackButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                getAdminUI().getModuleMenu().setVisible(true);
            }
        });

        placeComponents();
    }
    public void refreshDatabaseView() {
        getChildSelectorTable().showDegrees(); 
    }
    protected void placeComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(degreeLevelLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(getSelectParentLabel(), javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(getParentSelector(), 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(degreeLevelDropDown, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(seasonLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seasonDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(coreLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coreDropDown,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(creditsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(creditsField, javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
                                                .addComponent(getAddLinkButton())
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(getRemoveLinkButton())
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(backButton))
                                        .addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
                                                .addComponent(getChildSelectorTable(),
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup().addGap(10, 10, 10)
                                                .addComponent(getChildTableLabel()))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] { getAddLinkButton(), backButton, getRemoveLinkButton() });

        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(getSelectParentLabel()).addComponent(getParentSelector(),
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(degreeLevelLabel)
                                .addComponent(degreeLevelDropDown, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seasonLabel)
                                .addComponent(seasonDropDown, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(creditsLabel)
                                .addComponent(creditsField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(coreLabel)
                                .addComponent(coreDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, 
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getChildTableLabel())
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getChildSelectorTable(), javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(backButton).addComponent(getAddLinkButton())
                                .addComponent(getRemoveLinkButton()))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }
}