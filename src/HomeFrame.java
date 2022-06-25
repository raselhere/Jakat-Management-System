import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {
	private Container c;
	private JLabel label1;
	private JButton button1, button2, button3;
	private Font font;

	HomeFrame() {
		itsComponent();
	}

	public void itsComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.gray);
		c.setBounds(100, 100, 500, 400);

		font = new Font("Arial", Font.BOLD, 18);

		label1 = new JLabel("Home Screen");
		label1.setBounds(180, 20, 150, 50);
		label1.setFont(font);
		c.add(label1);

		button1 = new JButton("Admin");
		button1.setBounds(110, 100, 80, 40);
		button1.setBackground(Color.black);
		button1.setForeground(Color.white);
		c.add(button1);

		button2 = new JButton("Donor");
		button2.setBounds(200, 100, 80, 40);
		button2.setBackground(Color.black);
		button2.setForeground(Color.white);
		c.add(button2);

		button3 = new JButton("Donee");
		button3.setBounds(290, 100, 80, 40);
		button3.setBackground(Color.black);
		button3.setForeground(Color.white);
		c.add(button3);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* second admin pannel link up */
				AdminFrame frame = new AdminFrame();
				frame.setVisible(true);
				frame.setBounds(100, 100, 500, 650);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				frame.setVisible(true);

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* second Donor pannel link up */
				DonorFrame frame = new DonorFrame();
				frame.setVisible(true);
				frame.setBounds(100, 100, 500, 650);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				frame.setVisible(true);

			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/* second Donee pannel link up */
				DoneeFrame frame = new DoneeFrame();
				frame.setVisible(true);
				frame.setBounds(100, 100, 500, 650);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				frame.setVisible(true);

			}
		});

	}

	public static void main(String[] args) {
		HomeFrame h = new HomeFrame(); // Object creation
		h.setVisible(true);
		h.setBounds(100, 100, 500, 650);
		h.setResizable(false);
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
