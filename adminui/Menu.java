package adminui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Menu extends JPanel {

    private JPanel mainMenu;
    protected JButton backButton;

    public Menu(JPanel mainMenu) {

        this.mainMenu = mainMenu;

        backButton = new JButton();
        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                hideMenu();
            }
        });

        setVisible(false);
    }
    private void hideMenu() {
        setVisible(false);
        mainMenu.setVisible(true);
    }
}