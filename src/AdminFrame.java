
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame {
	private Container c;
	private JLabel headline, userLabel, passLabel;
	private JTextField userLabel1;
	private JPasswordField passLabel1;
	private JButton loginButton, homeButton; /* message */
	private Font font;

	AdminFrame() {
		itsComponents();
	}

	public void itsComponents() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GRAY);

		font = new Font("Arial", Font.BOLD, 18);

		headline = new JLabel("Admin login pannel");
		headline.setBounds(120, 60, 250, 50);
		headline.setBackground(Color.white);
		headline.setForeground(Color.black);
		headline.setFont(new Font("Calibri", Font.ITALIC, 30));
		c.add(headline);

		userLabel = new JLabel("Username : ");
		userLabel.setFont(font);
		userLabel.setBounds(70, 150, 150, 20);
		c.add(userLabel);

		userLabel1 = new JTextField();
		userLabel1.setBounds(190, 145, 180, 35);
		userLabel1.setFont(font);
		c.add(userLabel1);

		passLabel = new JLabel("Password : ");
		passLabel.setFont(font);
		passLabel.setBounds(70, 200, 200, 20);
		c.add(passLabel);

		passLabel1 = new JPasswordField();
		passLabel1.setBounds(190, 195, 180, 35);
		c.add(passLabel1);

		loginButton = new JButton("Login");
		loginButton.setBounds(190, 280, 90, 30);
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.white);
		loginButton.setFont(font);
		c.add(loginButton);

		homeButton = new JButton("Home");
		homeButton.setBounds(190, 340, 90, 30);
		homeButton.setBackground(Color.black);
		homeButton.setForeground(Color.white);
		homeButton.setFont(new Font("Arial", Font.BOLD, 16));
		c.add(homeButton);

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = userLabel1.getText();
				String password = passLabel1.getText();

				if (username.equals("admin") && password.equals("adminiBUS")) {
					JOptionPane.showMessageDialog(null, "You have succesfully logined in the admin pannel");
					dispose();
					AdminFrame2 frame = new AdminFrame2();
					frame.setVisible(true);
					frame.setVisible(true);
					frame.setBounds(100, 100, 500, 650);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}

			}

		});

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Returning to Home screen");
				dispose();
				HomeFrame h = new HomeFrame();
				h.setVisible(true);
				h.setBounds(100, 100, 500, 650);
				h.setResizable(false);
				h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}

		});

	}

	public static void main(String[] args) {
		AdminFrame frame = new AdminFrame();
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
