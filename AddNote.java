import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNote extends JFrame{
	public static String heading ;
	public static String body;
	private JTextField textField;
	public AddNote() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 228));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 26));
		textField.setBounds(10, 95, 551, 52);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 22));
		textArea.setBounds(10, 157, 955, 496);
		panel.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Today's Entry");
		lblNewLabel.setForeground(new Color(204, 51, 102));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(345, 10, 302, 71);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(204, 51, 102));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(773, 95, 192, 52);
		panel.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(204, 51, 102));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
                    Statement sta = con.createStatement();
                    String h, b,q;
                    h= textField.getText();
                    b= textArea.getText();
                    q= "insert into notes value"+"('"+h+"','"+b+"','"+Notes.notes_date+"')" ;
                    sta.executeUpdate(q);
                    setVisible(false);	
				}
				catch(Exception ep){
                    System.out.println(ep);
                }
			}
		});
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 23));
		btnSave.setBounds(571, 95, 192, 53);
		panel.add(btnSave);
		setSize(1000,700);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
