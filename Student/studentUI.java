package src.ui.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studentUI extends JFrame 
		implements ActionListener {
	
	private MainWindow mainWindow;
	
	public StudentUI (String title) throws HeadlessException{
		super(title);
		
		Toolkit toolkit = Toolkit.getDeafultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		
		setSize(screenSize.width/2, screenSize.height/2);
		setLocation(screenSize.width/4, screenSize.height/4);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
		String[] columnNames = {"module code","Teacher", "grade"}
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JButton logOffBtn = new JButton("Log off"),SOUTH;
		logOffbtn.setActiveCommand("logOff")
		logOffBtn.addActionListener(this);
		add(logOffBtn);
		
		contentPane.add(new JTable(data, columnNames),NORTH);		
	}
	
	public void actionPerformed (ActionEvent event)
	 String command = event.getActionCommand();
	 if (command.equals("logOff")) {
		 mainWindow.showLogInWindow();
		 
	 }
	
	public static void main(String[] args) {
		new StudentUI("test frame")
		
	}
	

	
}
