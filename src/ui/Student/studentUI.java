package src.ui.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
//import src.ui.MainWindow;
import java.sql.*;

public class studentUI extends JFrame 
		implements ActionListener {
	
	//private MainWindow mainWindow;
	
	public studentUI (String title) throws HeadlessException{
		super(title);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		
		setSize(screenSize.width/2, screenSize.height/2);
		setLocation(screenSize.width/4, screenSize.height/4);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		String userName = "something to be determined";
		
				
		String [] studentGrades = {};
		String [] studentTeachers = {};
		
		Connection con = null;
		Statement stmt = null;
		
		
		try {
		con = DriverManager.getConnection(
				"jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
		
		
		stmt = con.createStatement();
		
		ResultSet modules = stmt.executeQuery(
				"SELECT Module.ModuleCode,Module.Teaching Department,Mark.The mark FROM Student,Degree,Module degree (linking), Module, Mark WHERE Student.Registration number ="+userName+
				" AND student.Degree_DegreeCode = Degree.DegreeCode AND Module degree (linking).Degree_DegreeCode = Degree.DegreeCode AND "
				+ "Module degree (linking).Module_ModuleCode = Module.ModuleCode AND Module.ModuleCode = Mark.Module_ModuleCode);");
		int count = 0 ;
		while (modules.next()) {
			   count ++;
				}
		modules.first();
		String[] studentModules = new String[count];
		count=0;
		while (modules.next()) {
			studentModules[count]=modules.getString("module name");
			count++;
		}
		}
		catch (SQLException ex) {
			 ex.printStackTrace();
		}
		finally {}
	
		
		
		
		String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
		
				
		String[] columnNames = {"Module code","Teacher", "Grade"};
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JButton logOffBtn = new JButton("Log off");
		logOffBtn.setActionCommand("logOff");
		logOffBtn.addActionListener(this);
		add(logOffBtn,BorderLayout.SOUTH);
		
		contentPane.add(new JTable(data, columnNames),BorderLayout.NORTH);		
	}
	
	public void actionPerformed (ActionEvent event) {
	 String command = event.getActionCommand();
	 if (command.equals("logOff")) {
	//	 mainWindow.showLogInWindow();
		 
	 }
	}
	
	public static void main(String[] args) {
		
		
		String userName = "something to be determined";
				
				String [] studentModules = {};		
				String [] studentGrades = {};
				String [] studentTeachers = {};
				
				Connection con = null;
				Statement stmt = null;
				try {
				con = DriverManager.getConnection(
						"jdbc:mysql://stusql.dcs.shef.ac.uk/team046", "team046", "cbe569aa");
				
				
				stmt = con.createStatement();
				
				ResultSet modules = stmt.executeQuery(
						"SELECT Module.ModuleCode,Module.Teaching Department,Mark.The mark FROM Student,Degree,Module degree (linking), Module, Mark WHERE Student.Registration number ="+userName+
						" AND student.Degree_DegreeCode = Degree.DegreeCode AND Module degree (linking).Degree_DegreeCode = Degree.DegreeCode AND "
						+ "Module degree (linking).Module_ModuleCode = Module.ModuleCode AND Module.ModuleCode = Mark.Module_ModuleCode);");
				}
				catch (SQLException ex) {
					 ex.printStackTrace();
				}
				finally {}
		
	}
	

	
}
