package adminui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageDegreeLinksMenu extends LinkingMenu {

    public ManageDegreeLinksMenu(AdminUI adminUI) {
        
        super(adminUI);

        setAddLinkButtonText("Add Degree Link");
        setRemoveLinkButtonText("Remove Degree Link");
        setSelectParentLabelText("Select Degree: ");
        setChildTableLabelText("Select Departments(s) to add from table: ");
        setMenuTitle("Manage Degrees Links");
        setParentSelectorText(new String[] {"Degree 1", "Degree 2", "Degree 3", "Degree 4"});

        setBackButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                getAdminUI().getDegreeMenu().setVisible(true);
            }
        });

        placeComponents();
    }
}