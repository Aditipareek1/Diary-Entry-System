import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Canvas;
public class Welcome extends JFrame{
	JLabel l;
	
	Welcome()
	{
		setBackground(Color.LIGHT_GRAY);
		setTitle("Welcome");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 685, 436);
		panel_2.setBackground(new Color(255,206, 212));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.setBounds(274, 325, 133, 49);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Notes();
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(228, 106, 115));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Century Schoolbook", Font.BOLD, 26));
		
		Canvas canvas = new MyCanvas("C:\\Users\\ADITI\\eclipse-workspace\\ScrapBook\\Welcomeabc.jpg");
//		canvas.setBackground(new Color(15, 61, 62));
		canvas.setBounds(61, 38, 559, 281);
		panel_2.add(canvas);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(btnNewButton, BorderLayout.CENTER);
		/*
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_1);
		panel_2.setLayout(new BorderLayout(2, 2));
		
		JLabel lblNewLabel2 = new JLabel("WELCOME");
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton2 = new JButton("START");
		btnNewButton2.setForeground(Color.RED);
		btnNewButton2.setBackground(Color.ORANGE);
		btnNewButton2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel3.add(btnNewButton, BorderLayout.CENTER);*/
		
		setForeground(Color.DARK_GRAY);
		setTitle("Welcome");
		
		setSize(699,473);
		setLocationRelativeTo(null);
        setVisible(true);
		
	}
	public static void main(String[] args) {
		new Welcome();
		
	}
}
