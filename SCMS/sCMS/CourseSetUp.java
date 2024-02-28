package sCMS;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class CourseSetUp {
	private static JTextField courseName;
	private static JTextField txtCourseCode;
	private static JTextField txtInstructor;
	private static JTextField txtRoom;
	private static JPanel panel;
	private static JTable table;
	static DefaultTableModel model;
	private static JButton clear;
	private static JButton btnUpdate;

	public static void main(String[] args) {
		showCourseSetUpWindow();
	}
	
	public static void showCourseSetUpWindow() {
		JFrame frame = new JFrame("Course Set Up");
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(300, 100, 899, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		JLabel lblClose = new JLabel("x");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int resp1 = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?","Exit?", JOptionPane.YES_NO_OPTION);
				        if (resp1 == JOptionPane.YES_OPTION) {
				        	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        	frame.setVisible(false);
				        } else {
				        	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		lblClose.setBounds(866, 11, 23, 24);
		frame.getContentPane().add(lblClose);
		
		JLabel lblCourseSetup = new JLabel("Course Set-up");
		lblCourseSetup.setForeground(new Color(175, 238, 238));
		lblCourseSetup.setFont(new Font("Lucida Console", Font.BOLD, 23));
		lblCourseSetup.setBounds(350, 34, 197, 33);
		frame.getContentPane().add(lblCourseSetup);
		
		courseName = new JTextField();
		courseName.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		courseName.setColumns(10);
		courseName.setBounds(122, 100, 318, 33);
		frame.getContentPane().add(courseName);
		
		txtCourseCode = new JTextField();
		txtCourseCode.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		txtCourseCode.setColumns(10);
		txtCourseCode.setBounds(122, 144, 318, 33);
		frame.getContentPane().add(txtCourseCode);
		
		txtInstructor = new JTextField();
		txtInstructor.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		txtInstructor.setColumns(10);
		txtInstructor.setBounds(122, 188, 318, 33);
		frame.getContentPane().add(txtInstructor);
		
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		txtRoom.setColumns(10);
		txtRoom.setBounds(122, 232, 318, 33);
		frame.getContentPane().add(txtRoom);
		
		panel = new JPanel();
		panel.setBounds(450, 128, 439, 296);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				txtCourseCode.setText(model.getValueAt(i, 0).toString());
				courseName.setText(model.getValueAt(i, 1).toString());
				txtInstructor.setText(model.getValueAt(i, 2).toString());
				txtRoom.setText(model.getValueAt(i, 3).toString());
			}
		});
		
		table.setBackground(new Color(173, 216, 230));
		panel.add(table);
		model = new DefaultTableModel();
		Object[] column = {"Code", "Name", "Instructor", "Room"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setRowHeight(30);
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtCourseCode.getText().equals(" ") || courseName.getText().equals(" ") || txtInstructor.getText().equals(" ") || txtRoom.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "Fill all necessary Fields");
				}else {
					insertToDB();	
				row[0] = txtCourseCode.getText();
				row[1] = courseName.getText();
				row[2] = txtInstructor.getText();
				row[3] = txtRoom.getText();
				model.addRow(row);
				
				txtCourseCode.setText(" ");
				courseName.setText(" ");
				txtInstructor.setText(" ");
				txtRoom.setText(" ");
				
				}
			}
		});
		
		btnAdd.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnAdd.setBounds(124, 343, 105, 39);
		frame.getContentPane().add(btnAdd);
		
		
		
		JButton delete =new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i<=0) {
				deleteToDB();
				model.removeRow(i);
				}else {
					JOptionPane.showMessageDialog(null, "Select an item first");
				}
			}
		});
		delete.setFont(new Font("Lucida Console", Font.BOLD, 18));
		delete.setBounds(123, 409, 106, 39);
		frame.getContentPane().add(delete);
		
		clear = new JButton("CLEAR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCourseCode.setText(" ");
				courseName.setText(" ");
				txtInstructor.setText(" ");
				txtRoom.setText(" ");
			}
		});
		
		clear.setFont(new Font("Lucida Console", Font.BOLD, 18));
		clear.setBounds(271, 409, 106, 39);
		frame.getContentPane().add(clear);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if(i >= 0) {
					
				model.setValueAt(txtCourseCode.getText(), i, 0);
				model.setValueAt(courseName.getText(), i, 1);
				model.setValueAt(txtInstructor.getText(), i, 2);
				model.setValueAt(txtRoom.getText(), i, 3);
				JOptionPane.showMessageDialog(null, "Course Updated!");
				}else {
					JOptionPane.showMessageDialog(null, "Please select a record first");
				}
			}
		});
		btnUpdate.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnUpdate.setBounds(271, 343, 106, 39);
		frame.getContentPane().add(btnUpdate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(450, 100, 439, 24);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(106, 0, 66, 24);
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		panel_1.add(lblName);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setForeground(Color.BLACK);
		lblCode.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblCode.setBounds(0, 0, 77, 24);
		panel_1.add(lblCode);
		
		JLabel lblInstructor_1 = new JLabel("Instructor");
		lblInstructor_1.setForeground(Color.BLACK);
		lblInstructor_1.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblInstructor_1.setBounds(225, 0, 77, 24);
		panel_1.add(lblInstructor_1);
		
		JLabel lblRoom_1 = new JLabel("Room");
		lblRoom_1.setForeground(Color.BLACK);
		lblRoom_1.setFont(new Font("Lucida Bright", Font.BOLD, 13));
		lblRoom_1.setBounds(362, 0, 77, 24);
		panel_1.add(lblRoom_1);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setForeground(new Color(173, 216, 230));
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 100, 112, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setForeground(new Color(173, 216, 230));
		lblCourseCode.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblCourseCode.setBounds(10, 144, 124, 33);
		frame.getContentPane().add(lblCourseCode);
		
		JLabel lblInstructor = new JLabel("Instructor");
		lblInstructor.setForeground(new Color(173, 216, 230));
		lblInstructor.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblInstructor.setBounds(10, 188, 105, 33);
		frame.getContentPane().add(lblInstructor);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setForeground(new Color(173, 216, 230));
		lblRoom.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblRoom.setBounds(10, 232, 105, 33);
		frame.getContentPane().add(lblRoom);
		

	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/student";
			Class.forName(driver);
			return DriverManager.getConnection(url, "root", "d0y0urbes+!");
		}catch(Exception e){
			System.out.println("Connection error" + e);
		}
		return null;
	}
	
	public static void insertToDB() {
		Connection con = con();
		try {
			String query = "INSERT INTO course1(Code, Name, Instructor, Room)" + "VALUES (?,?,?,?)";
			PreparedStatement pS = con.prepareStatement(query);
			pS.setString( 1, txtCourseCode.getText());
			pS.setString( 2, courseName.getText());
			pS.setString( 3, txtInstructor.getText());
			pS.setString( 4, txtRoom.getText());
			
		pS.executeUpdate();
		
		if(pS.executeUpdate()>0) {
			JOptionPane.showMessageDialog(null, "Course Updated!");
		}
			
		}catch (Exception e) {
			System.out.println("Error" + e);
		}
				
	}
	
	public static void updateToDB() {
		Connection con = con();
		DefaultTableModel tble = (DefaultTableModel)table.getModel();
		int selectedIndex = table.getSelectedRow();
		try {
			String query = "UPDATE course1 SET Code=?, Name=?, Instructor=?, Room=? WHERE i=?";
			int i = Integer.parseInt(tble.getValueAt(selectedIndex, 0).toString());
			PreparedStatement pS = con.prepareStatement(query);
			pS.setString( 1, txtCourseCode.getText());
			pS.setString( 2, courseName.getText());
			pS.setString( 3, txtInstructor.getText());
			pS.setString( 4, txtRoom.getText());
			pS.setInt( 5, i);
			
			if(pS.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Course Updated!");
			}
			
			
		}catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
		
		public static void deleteToDB() {
			Connection con = con();
			try {
				String query = "DELETE FROM course1  WHERE Code=?";
				PreparedStatement pS = con.prepareStatement(query);
				pS.setString( 1, txtCourseCode.getText());
				
				if(pS.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Course Deleted!");
				}
				
			}catch (Exception e) {
				System.out.println("Error" + e);
			}
	}
}

