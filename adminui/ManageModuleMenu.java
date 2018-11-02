package adminui;

import javax.swing.JPanel;

public class ManageModuleMenu extends Menu {

    public ManageModuleMenu(JPanel mainMenu) {

        super(mainMenu);
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
    }
}
