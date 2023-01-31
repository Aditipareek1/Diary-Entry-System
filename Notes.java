import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.Date;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import java.awt.SystemColor;

public class Notes extends JFrame{
	public static String notes_date;
	JPanel panel;
//	Container c;
	public Notes() {
//		c=getContentPane();
		getContentPane().setLayout(new GridLayout(0, 1, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 245, 228));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = new Date();
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(204, 51, 102));
		btnNewButton.setBounds(808, 247, 150, 40);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 15));
		
		JButton btnAddNotes = new JButton("ADD ENTRIES");
		btnAddNotes.setForeground(Color.WHITE);
		btnAddNotes.setBackground(new Color(204, 51, 102));
		btnAddNotes.setBounds(639, 247, 159, 40);
		panel_1.add(btnAddNotes);
		btnAddNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNote();
			}
		});
		btnAddNotes.setFont(new Font("Georgia", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("Welcome "+Login.username);
		lblNewLabel.setForeground(new Color(204, 0, 102));
		lblNewLabel.setBounds(10, 58, 374, 80);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 52));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSelectDate = new JLabel("SELECT DATE");
		lblSelectDate.setForeground(Color.BLACK);
		lblSelectDate.setBounds(10, 205, 187, 40);
		panel_1.add(lblSelectDate);
		lblSelectDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectDate.setFont(new Font("High Tower Text", Font.BOLD, 23));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(Color.BLACK);
		dateChooser.setBackground(new Color(240, 230, 140));
		dateChooser.setBounds(10, 247, 277, 40);
		panel_1.add(dateChooser);
		
		dateChooser.setToolTipText("Select Date");
		dateChooser.setDate(date);
		
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 245, 228));
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 0));
		panel.setBounds(0, 322, 986, 481);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		Canvas canvas = new MyCanvas("C:\\Users\\ADITI\\eclipse-workspace\\ScrapBook\\diary3.jpg");
		canvas.setBounds(399, -29, 559, 253);
		panel_1.add(canvas);
		notes_date = df.format(dateChooser.getDate());
		
		dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
			   public void propertyChange(PropertyChangeEvent e)  {
				   panel.removeAll();
				   panel.repaint();
				   panel.revalidate();
				   try {
					    notes_date = df.format(((JDateChooser)e.getSource()).getDate());
				   		Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
				        Statement sta = con.createStatement();
				        System.out.println("notes_date1 " + notes_date);
				        ResultSet results = sta.executeQuery("SELECT heading FROM notes where date =" +"'"+notes_date+"'");
				        //panel.setBackground(Color.PINK);
				        while(results.next())
				        {
				        	 String headingg = results.getString("heading");
				        	 System.out.println(headingg);
				        	 JLabel label= new JLabel(headingg);
				        	 panel.add(label);
				        	 //label.setFont(new Font("Times New Roman", Font.BOLD, 22));
				        	 label.setFont(new Font("Century Gothic", Font.PLAIN, 30));
				     		label.setHorizontalAlignment(SwingConstants.CENTER);
				     		label.addMouseListener(new MouseAdapter() {
				    			public void mouseClicked(MouseEvent e) {
				    				new LabelBody(headingg);
				    			}
				    		});
				        }
				        	
				   	   }
				   		catch(Exception ep) {
				   			System.out.println(ep);
//				   			JOptionPane.showMessageDialog(ep);
				   		}
			      }

			
			   });
		
		setSize(1000,850);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Notes();

	}
}
