package sCMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Welcome {
	
	public static void main(String[] args) {
		showWelcomeConsoleWindow();
	}
	
	public static void showWelcomeConsoleWindow() {
		JFrame frame = new JFrame("Opening");
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(250, 100, 646, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		lblClose.setBounds(613, 14, 23, 24);
		frame.getContentPane().add(lblClose);
		
		JLabel welcome = new JLabel("Student's Course Management System");
		welcome.setForeground(new Color(173, 216, 230));
		welcome.setFont(new Font("Luna", Font.PLAIN, 22));
		welcome.setBounds(51, 49, 560, 170);
		frame.getContentPane().add(welcome);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CourseSetUp.showCourseSetUpWindow();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStart.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblStart.setForeground(Color.WHITE);
			}
		});
		lblStart.setForeground(new Color(173, 216, 230));
		lblStart.setFont(new Font("Luna", Font.PLAIN, 20));
		lblStart.setBounds(267, 230, 99, 94);
		frame.getContentPane().add(lblStart);
		frame.setVisible(true);
	}

}
