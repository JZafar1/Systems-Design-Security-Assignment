package adminui;

import javax.swing.JPanel;

public class ManageModuleMenu extends JPanel {

    private JPanel mainMenu;

    public ManageModuleMenu(JPanel mainMenu) {

        this.mainMenu = mainMenu;
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
    }
}
