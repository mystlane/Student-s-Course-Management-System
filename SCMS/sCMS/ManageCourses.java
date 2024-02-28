package sCMS;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCourses {
	private static JTextField name;
	private static JTextField code;
	private static JTextField instruct;
	private static JTextField credits;
	private static JTextField room;
	private static JTable table;

	public static void main(String[] args) {
		showManageCoursesWindow();

	}
	

	public static void showManageCoursesWindow() {
		JFrame frame = new JFrame("Opening");
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.getContentPane().setLayout(null);
		
		name = new JTextField();
		name.setText("Course Name");
		name.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		name.setColumns(10);
		name.setBounds(10, 102, 411, 33);
		frame.getContentPane().add(name);
		
		code = new JTextField();
		code.setText("Course Code");
		code.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		code.setColumns(10);
		code.setBounds(10, 146, 165, 33);
		frame.getContentPane().add(code);
		
		instruct = new JTextField();
		instruct.setText("Instructor");
		instruct.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		instruct.setColumns(10);
		instruct.setBounds(10, 190, 331, 33);
		frame.getContentPane().add(instruct);
		
		credits = new JTextField();
		credits.setText("Credits");
		credits.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		credits.setColumns(10);
		credits.setBounds(10, 234, 90, 33);
		frame.getContentPane().add(credits);
		
		room = new JTextField();
		room.setText("Room");
		room.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		room.setColumns(10);
		room.setBounds(10, 277, 153, 33);
		frame.getContentPane().add(room);
		
		JButton addButton = new JButton("ADD");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insertToDB();
			}
		});
		addButton.setFont(new Font("Lucida Console", Font.BOLD, 18));
		addButton.setBounds(10, 340, 105, 39);
		frame.getContentPane().add(addButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(431, 90, 427, 361);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.setBackground(new Color(173, 216, 230));
		panel.add(table);
		frame.setBounds(100, 100, 881, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	static Connection con() {
		try {
			String driver = "custom.driver";
			String url = "custom.url";
			Class.forName(driver);
			return DriverManager.getConnection(url, "root", "password");
		}catch(Exception e){
			System.out.println("Connection error" + e);
		}
		return null;
	}
	// TODO:Set up JDBC connection parameters.
   // - Replace "custom.driver" with the JDBC driver class name for your database.
  // - Replace "custom.url" with the JDBC URL for connecting to your database.
	
	public static void insertToDB() {
		Connection con = con();
		try {
			String query = "INSERT INTO course1(Code, Name, Instructor, Credits, Room)" + "VALUES (?,?,?,?,?)";
			PreparedStatement pS = con.prepareStatement(query);
			pS.setString( 1, code.getText());
			pS.setString( 2, name.getText());
			pS.setString( 3, instruct.getText());
			pS.setString( 4, credits.getText());
			pS.setString( 5, room.getText());
			
			if(pS.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Course Added!");
			}
			
		}catch (Exception e) {
			System.out.println("Error" + e);
		}
				
	}

}


















