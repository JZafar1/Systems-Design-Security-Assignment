package teacherui;

import javax.swing.*;
import java.awt.*;

public class TeacherMainMenu extends Menu {
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel currentlySelectedLabel;
    private javax.swing.JTextField searchQuery;
    private javax.swing.JTextField displayResults;
    private javax.swing.JTextField currentlySelected;
    private javax.swing.JButton search;
    private javax.swing.JButton editGrades;
    private javax.swing.JButton registerStudent;
    private javax.swing.JButton viewResults;

    public TeacherMainMenu (TeacherGUI teaherui) {
        super(teacherui);
        setVisible(true);
        initComponents();
        placeComponents();
    }

    public void initComponents() {
        searchLabel = new JLabel();
        searchLabel.setText("Search for student");
        searchQuery = new JTextField();
        displayResults = new jTextField();
        currentlySelectedLabel = new JLabel();
        currentlySelectedLabel.setText("Current Student");
        currentlySelected = new JTextField();
        currentlySelected.setEditable(false);
        search = new JButton();
        editGrades = new JButton();
        registerStudent = new JButton();
        viewResults = new JButton();

        search.setText("Search");
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Query DB
            }
        });
        editGrades.setText("Search");
        editGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eidtGradesMenu();
            }
        });
        registerStudent.setText("Search");
        registerStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerStudentMenu();
            }
        });
        viewResults.setText("Search");
        viewResults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewResultsMenu();
            }
        });
    }

    public void editGradesMenu() {

    }

    public void registerStudentMenu() {

    }

    public void viewResultsMenu() {
        
    }

    public void placeComponents() {
        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(this);
        mainMenu.setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(displayResults)
                            .addGroup(mainMenuLayout.createSequentialGroup()
                                .addComponent(searchLabel)
                                .addGap(18, 18, 18)
                                .addComponent(searchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainMenuLayout.createSequentialGroup()
                                .addComponent(currentlySelectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(currentlySelected, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addComponent(editGrades)
                        .addGap(18, 18, 18)
                        .addComponent(registerStudent)
                        .addGap(18, 18, 18)
                        .addComponent(viewResults)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayResults, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentlySelectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentlySelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editGrades)
                    .addComponent(registerStudent)
                    .addComponent(viewResults))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
}
