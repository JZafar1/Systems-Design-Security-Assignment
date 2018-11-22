package src.ui.registrar;

import javax.swing.JPanel;
import src.ui.MainWindow;
import src.ui.registrar.ManageStudents;

/**
 * Class extends JPanel and houses all the registrar ui elements, and can display and
 * hide the menus in registrarUI.
 */
public class RegistrarUI extends JPanel {

    private MainWindow mainWindow;

    public RegistrarUI(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setVisible(true);
        showRegistrarMenu();
        //showManageStudents();
        //showManageModules();
    }
    public void showRegistrarMenu() {
        removeAll();
        placeMenuComponent(new Registrar(this));
        repaint();
    }
    public void showManageStudents() {
        removeAll();
        placeMenuComponent(new ManageStudents(this));
        repaint();
    }
    public void showManageModules() {
        removeAll();
        placeMenuComponent(new ManageModules(this));
        repaint();
    }
    private void placeMenuComponent(JPanel menu) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
    }
}