import java.awt.*;
import java.sql.* ;
import javax.swing.* ;
public class ShowNotes extends JFrame{
	public ShowNotes(String h) {
		getContentPane().setBackground(new Color(255, 245, 228));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(h);
		lblNewLabel.setForeground(new Color(204, 51, 102));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 24));
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 695, 42);
		getContentPane().add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
//		lblNewLabel_1.setBackground(SystemColor.activeCaption);
//		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
//		lblNewLabel_1.setBounds(10, 85, 695, 427);
//		getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		textArea.setBounds(10, 85, 695, 427);
		getContentPane().add(textArea);

		setSize(730,559);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
            Statement sta = con.createStatement();
            ResultSet rs= sta.executeQuery("SELECT body FROM notes WHERE heading="+"'"+h+"'");
            String content;
            rs.next();
            content= rs.getString("body");
            System.out.println(content);
            textArea.setText(content);
    		
            
		}
		catch(Exception ep) {
			System.out.println(ep);
		}
	}
}
