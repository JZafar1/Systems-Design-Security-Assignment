package adminui;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageModuleLinksMenu extends LinkingMenu {

    public ManageModuleLinksMenu(AdminUI adminUI) {

        super(adminUI);

        setAddLinkButtonText("Add Module Link");
        setRemoveLinkButtonText("Remove Module Link");
        setSelectParentLabelText("Select Module: ");
        setChildTableLabelText("Select Degree(s) to add from table: ");
        setMenuTitle("Manage Module Links");
        setParentSelectorText(new String[] {"Module 1", "Module 2", "Module 3", "Module 4"});

        setBackButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                getAdminUI().getModuleMenu().setVisible(true);
            }
        });

        placeComponents();
    }
}