package adminui;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class DatabasePanel extends JScrollPane{

    private JPanel mainMenu;
    private JTextArea jTextArea;

    public DatabasePanel(JPanel mainMenu) {

        this.mainMenu = mainMenu;
        jTextArea = new JTextArea();

        setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        setViewportView(jTextArea);
    }
}