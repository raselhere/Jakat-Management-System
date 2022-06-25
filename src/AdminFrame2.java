import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame2 extends JFrame {
	private Container c;
	private JLabel headline;
	private JButton homeButton, collectionButton, doneeButton, logoutButton, distributeButton;

	AdminFrame2() {
		itsComponent();
	}

	public void itsComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GRAY);

		headline = new JLabel("Admin pannel");
		headline.setBounds(150, 60, 250, 50);
		headline.setBackground(Color.white);
		headline.setForeground(Color.black);
		headline.setFont(new Font("Calibri", Font.ITALIC, 30));
		c.add(headline);

		homeButton = new JButton("Home");
		homeButton.setBounds(50, 20, 70, 30);
		homeButton.setBackground(Color.black);
		homeButton.setForeground(Color.white);
		homeButton.setFont(new Font("Arial", Font.BOLD, 12));
		c.add(homeButton);

		collectionButton = new JButton("Collection");
		collectionButton.setBounds(170, 260, 150, 30);
		collectionButton.setBackground(Color.black);
		collectionButton.setForeground(Color.white);
		collectionButton.setFont(new Font("Arial", Font.BOLD, 18));
		c.add(collectionButton);

		doneeButton = new JButton("Donee Number");
		doneeButton.setBounds(140, 320, 200, 30);
		doneeButton.setBackground(Color.black);
		doneeButton.setForeground(Color.white);
		doneeButton.setFont(new Font("Arial", Font.BOLD, 18));
		c.add(doneeButton);

		distributeButton = new JButton("Distribute");
		distributeButton.setBounds(140, 380, 200, 30);
		distributeButton.setBackground(Color.black);
		distributeButton.setForeground(Color.white);
		distributeButton.setFont(new Font("Arial", Font.BOLD, 18));
		c.add(distributeButton);

		logoutButton = new JButton("Logout");
		logoutButton.setBounds(140, 440, 200, 30);
		logoutButton.setBackground(Color.black);
		logoutButton.setForeground(Color.white);
		logoutButton.setFont(new Font("Arial", Font.BOLD, 15));
		c.add(logoutButton);

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Returning to Home screen");
				dispose();
				HomeFrame h = new HomeFrame();
				h.setVisible(true);
				h.setResizable(false);
				h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}

		});

		collectionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double tempAmount = Collection.amountFromFile();
				JOptionPane.showMessageDialog(null, "zakat amount : " + tempAmount);

			}

		});

		doneeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "The number of Donee is " + Donee.DoneeCounterMethod());

			}

		});

		distributeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Distribution.distributeToDonees();
					JOptionPane.showMessageDialog(null, "Donation distributed successfully among the donees");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error occured");
				}
			}

		});

		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Logging Out");
				dispose();
				AdminFrame frame = new AdminFrame();
				frame.setVisible(true);
				frame.setVisible(true);
				frame.setBounds(100, 100, 500, 650);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}

		});
	}

	public static void main(String[] args) {
		AdminFrame2 frame = new AdminFrame2();
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
