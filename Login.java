import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.SystemColor;

public class Login extends JFrame {
	static String username;
	JLabel l1, l2;
	JButton b1;
	JTextField tf1;
	JPasswordField pf;

	Login() {
		getContentPane().setBackground(new Color(238, 105, 131));
		setTitle("Login");

		setSize(780, 588);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(173, 58, 457, 442);
		getContentPane().add(panel);
		panel.setLayout(null);
		tf1 = new JTextField();
		tf1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		tf1.setBackground(SystemColor.menu);
		tf1.setBounds(166, 154, 252, 44);
		panel.add(tf1);
		l1 = new JLabel("Username");
		l1.setForeground(Color.BLACK);
		l1.setBackground(new Color(154, 205, 50));
		l1.setBounds(54, 158, 92, 40);
		panel.add(l1);
		l1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pf = new JPasswordField();
		pf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pf.setBackground(SystemColor.menu);
		pf.setBounds(166, 225, 252, 44);
		panel.add(pf);
		l2 = new JLabel("Password");
		l2.setForeground(Color.BLACK);
		l2.setBackground(new Color(0, 128, 128));
		l2.setBounds(54, 229, 92, 40);
		panel.add(l2);
		l2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		b1 = new JButton("Login");
		b1.setForeground(new Color(255, 255, 255));
		b1.setBounds(54, 329, 364, 43);
		panel.add(b1);
		b1.setBackground(new Color(204, 51, 102));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 30));

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 46));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(144, 31, 178, 91);
		panel.add(lblNewLabel);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook", "root",
							"root");
					Statement sta = con.createStatement();
					String p, q;
					String p1, q1;
					p = tf1.getText();
					q = new String(pf.getPassword());
					ResultSet rs = sta.executeQuery("SELECT *FROM login");
					int flag = 0;
					while (rs.next()) {
						p1 = rs.getString("username");
						q1 = rs.getString("pswd");

						if (p.equals(p1) && q.equals(q1)) {
							flag = 1;
//                    		User.username = p;
							username = p;
						}
					}
					if (flag == 0) {
						JOptionPane.showMessageDialog(null, "invalid username and password");
					} else {
						new Welcome();
						setVisible(false);
					}
				}

				catch (Exception ep) {
					System.out.println(ep);
				}
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
