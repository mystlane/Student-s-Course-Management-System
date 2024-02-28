package sCMS;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class CreateAccount {
	private static JTextField lastName;
	private static JTextField firstName;
	private static JTextField middleName;
	private static JTextField yearLevel;
	private static JTextField userName;
	private static JPasswordField password;
	private static JTextField program;

	public static void main(String[] args) {	
		showCreateAccountWindow();
	}
	
	public static void showCreateAccountWindow() {
		JFrame frmCreateAccount = new JFrame("Create Account");
		frmCreateAccount.setUndecorated(true);
		frmCreateAccount.setBackground(new Color(255, 250, 250));
		frmCreateAccount.setTitle("Create Account");
		frmCreateAccount.getContentPane().setBackground(new Color(0, 0, 128));
		frmCreateAccount.setBounds(100, 100, 879, 443);
		frmCreateAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateAccount.getContentPane().setLayout(null);
		frmCreateAccount.setVisible(true);
		
		JLabel lblClose = new JLabel("x");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int resp1 = JOptionPane.showConfirmDialog(frmCreateAccount, "Are you sure you want to exit?","Exit?", JOptionPane.YES_NO_OPTION);
				        if (resp1 == JOptionPane.YES_OPTION) {
				        	frmCreateAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        	frmCreateAccount.setVisible(false);
				        } else {
				        	frmCreateAccount.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				        }
			}
						@Override
						public void mouseEntered(MouseEvent e) {
							lblClose.setForeground(Color.RED);
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							lblClose.setForeground(Color.WHITE);
						}
							});
		lblClose.setForeground(new Color(224, 255, 255));
		lblClose.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblClose.setBounds(849, 11, 20, 24);
		frmCreateAccount.getContentPane().add(lblClose);
		
		JLabel lblCreateAccount = new JLabel("Create Your Account");
		lblCreateAccount.setForeground(new Color(175, 238, 238));
		lblCreateAccount.setFont(new Font("Lucida Console", Font.BOLD, 23));
		lblCreateAccount.setBounds(292, 34, 281, 33);
		frmCreateAccount.getContentPane().add(lblCreateAccount);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(176, 224, 230));
		lblLastName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblLastName.setBounds(67, 92, 106, 33);
		frmCreateAccount.getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lastName.setBounds(201, 92, 172, 33);
		frmCreateAccount.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(176, 224, 230));
		lblFirstName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblFirstName.setBounds(67, 136, 124, 33);
		frmCreateAccount.getContentPane().add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		firstName.setColumns(10);
		firstName.setBounds(201, 136, 172, 33);
		frmCreateAccount.getContentPane().add(firstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setForeground(new Color(176, 224, 230));
		lblMiddleName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblMiddleName.setBounds(67, 180, 124, 33);
		frmCreateAccount.getContentPane().add(lblMiddleName);
		
		middleName = new JTextField();
		middleName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		middleName.setColumns(10);
		middleName.setBounds(201, 180, 172, 33);
		frmCreateAccount.getContentPane().add(middleName);
		
		JLabel lblYearLevel = new JLabel("Year Level");
		lblYearLevel.setForeground(new Color(176, 224, 230));
		lblYearLevel.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblYearLevel.setBounds(406, 92, 124, 33);
		frmCreateAccount.getContentPane().add(lblYearLevel);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setForeground(new Color(176, 224, 230));
		lblProgram.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblProgram.setBounds(406, 136, 124, 33);
		frmCreateAccount.getContentPane().add(lblProgram);
		
		yearLevel = new JTextField();
		yearLevel.setBounds(532, 92, 200, 33);
		yearLevel.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		yearLevel.setColumns(10);
		frmCreateAccount.getContentPane().add(yearLevel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 235, 750, 7);
		frmCreateAccount.getContentPane().add(separator);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(176, 224, 230));
		lblUsername.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblUsername.setBounds(67, 253, 106, 33);
		frmCreateAccount.getContentPane().add(lblUsername);
		
		userName = new JTextField();
		userName.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		userName.setColumns(10);
		userName.setBounds(201, 253, 172, 33);
		frmCreateAccount.getContentPane().add(userName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(176, 224, 230));
		lblPassword.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		lblPassword.setBounds(67, 300, 106, 33);
		frmCreateAccount.getContentPane().add(lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		password.setBounds(201, 297, 172, 36);
		frmCreateAccount.getContentPane().add(password);
		
		program = new JTextField();
		program.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		program.setColumns(10);
		program.setBounds(532, 136, 291, 33);
		frmCreateAccount.getContentPane().add(program);
		
		
		
		JButton button = new JButton("Sign Up");
		button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(lastName.getText().equals(" ") || firstName.getText().equals(" ") || middleName.getText().equals(" ") || yearLevel.getText().equals(" ") || program.getText().equals(" ")|| userName.getText().equals(" ") || password.getText().equals(" ")) {
								JOptionPane.showMessageDialog(null, "Fill all necesssary Fields");
							}else {
							insertToDB();
							frmCreateAccount.setVisible(false);
							}
						}
					});
		
		button.setFont(new Font("Lucida Console", Font.BOLD, 18));
		button.setBounds(620, 348, 155, 39);
		frmCreateAccount.getContentPane().add(button); 
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastName.setText(" ");
				firstName.setText(" ");
				middleName.setText(" ");
				yearLevel.setText(" ");
				program.setText(" ");
				userName.setText(" ");
				password.setText(" ");
			}
		});
		clear.setFont(new Font("Lucida Console", Font.BOLD, 18));
		clear.setBounds(418, 348, 155, 39);
		frmCreateAccount.getContentPane().add(clear);
		
	}
	
	static Connection con() {
		try {
			String driver = "custom.driver";
			String url = "custom url";
			Class.forName(driver);
			return DriverManager.getConnection(url, "root", "d0y0urbes+!");
		}catch(Exception e){
			System.out.println("Connection error" + e);
		}
		return null;
	}

	// TODO: Customize the JDBC driver and database URL based on your environment
   // You can modify the 'driver' and 'url' variables here to point to your specific database
 
	
	public static void insertToDB() {
		Connection con = con();
		try {
			String query = "INSERT INTO studentinfo(Username, Password, LastName,FirstName, MiddleName, YearLevel, Program)" + "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pS = con.prepareStatement(query);
			pS.setString( 1, userName.getText());
			pS.setString( 2, password.getText());
			pS.setString( 3, lastName.getText());
			pS.setString( 4, firstName.getText());
			pS.setString( 5, middleName.getText());
			pS.setString( 6, yearLevel.getText());
			pS.setString( 7, program.getText());
			
			if(pS.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Account Created!");
				LogIn.showLogInWindow();
			}
			
		}catch (Exception e) {
			System.out.println("Error" + e);
		}
				
	}
}
