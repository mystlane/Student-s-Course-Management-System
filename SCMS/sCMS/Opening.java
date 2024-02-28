package sCMS;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Opening{


		public static void main (String[] args) {
			showOpening();
		}
		
		
	public static void showOpening() {
		JFrame frame = new JFrame("Opening");
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(380, 250, 568, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblSCMS = new JLabel("Student's Course Management System");
		lblSCMS.setForeground(new Color(135, 206, 235));
		lblSCMS.setBounds(30, 34, 495, 24);
		lblSCMS.setFont(new Font("Lucida Console", Font.BOLD, 23));
		frame.getContentPane().add(lblSCMS);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LogIn.showLogInWindow();
			}
		});
		btnLogIn.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnLogIn.setBounds(102, 107, 155, 39);
		frame.getContentPane().add(btnLogIn);
		
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CreateAccount.showCreateAccountWindow();
			}
		});
		btnSignUp.setFont(new Font("Lucida Console", Font.BOLD, 18));
		btnSignUp.setBounds(304, 107, 155, 39);
		frame.getContentPane().add(btnSignUp);
		
		JLabel lblClose = new JLabel("x");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int resp = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?",
				            "Exit?", JOptionPane.YES_NO_OPTION);
				        if (resp == JOptionPane.YES_OPTION) {
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
		lblClose.setBounds(535, 11, 23, 24);
		frame.getContentPane().add(lblClose);
		
		
		
	}
}
