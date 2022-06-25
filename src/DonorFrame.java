import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DonorFrame extends JFrame {
	private Container c;
	private JLabel headline, nameLabel, ageLabel, phoneNoLabel, NIDLabel, accNoLabel, bankNameLabel, mainBalanceLabel;
	private JTextField nameLabel1, ageLabel1, phoneNoLabel1, NIDLabel1, accNoLabel1, bankNameLabel1, mainBalanceLabel1;
	private JButton submitButton, homeButton;

	DonorFrame() {
		itsComponent();
	}

	public void itsComponent() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.gray);

		headline = new JLabel("Donor Information");
		headline.setBounds(120, 20, 300, 30);
		headline.setFont(new Font("Calibri", Font.ITALIC, 30));
		c.add(headline);

		nameLabel = new JLabel("Name :");
		nameLabel.setBounds(0, 100, 150, 20);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		c.add(nameLabel);

		nameLabel1 = new JTextField();
		nameLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		nameLabel1.setBounds(160, 95, 250, 30);
		nameLabel1.setBackground(Color.black);
		nameLabel1.setForeground(Color.white);
		c.add(nameLabel1);

		ageLabel = new JLabel("Age :");
		ageLabel.setBounds(0, 140, 150, 20);
		ageLabel.setFont(new Font("Arial", Font.BOLD, 16));
		ageLabel.setHorizontalAlignment(JLabel.RIGHT);
		c.add(ageLabel);

		ageLabel1 = new JTextField();
		ageLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		ageLabel1.setBounds(160, 135, 250, 30);
		ageLabel1.setBackground(Color.black);
		ageLabel1.setForeground(Color.white);
		c.add(ageLabel1);

		phoneNoLabel = new JLabel("Phone Number :");
		phoneNoLabel.setBounds(0, 180, 150, 20);
		phoneNoLabel.setFont(new Font("Arial", Font.BOLD, 16));
		phoneNoLabel.setHorizontalAlignment(JLabel.RIGHT);
		c.add(phoneNoLabel);

		phoneNoLabel1 = new JTextField();
		phoneNoLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		phoneNoLabel1.setBounds(160, 175, 250, 30);
		phoneNoLabel1.setBackground(Color.black);
		phoneNoLabel1.setForeground(Color.white);
		c.add(phoneNoLabel1);

		NIDLabel = new JLabel("NID Number :");
		NIDLabel.setBounds(0, 220, 150, 20);
		NIDLabel.setFont(new Font("Arial", Font.BOLD, 16));
		NIDLabel.setHorizontalAlignment(JLabel.RIGHT);
		c.add(NIDLabel);

		NIDLabel1 = new JTextField();
		NIDLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		NIDLabel1.setBounds(160, 215, 250, 30);
		NIDLabel1.setBackground(Color.black);
		NIDLabel1.setForeground(Color.white);
		c.add(NIDLabel1);

		accNoLabel = new JLabel("Account Number :");
		accNoLabel.setBounds(0, 260, 150, 20);
		accNoLabel.setFont(new Font("Arial", Font.BOLD, 16));
		accNoLabel.setHorizontalAlignment(JLabel.RIGHT);
		c.add(accNoLabel);

		accNoLabel1 = new JTextField();
		accNoLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		accNoLabel1.setBounds(160, 255, 250, 30);
		accNoLabel1.setBackground(Color.black);
		accNoLabel1.setForeground(Color.white);
		c.add(accNoLabel1);

		bankNameLabel = new JLabel("Bank Name :");
		bankNameLabel.setBounds(0, 300, 150, 20);
		bankNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		bankNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		c.add(bankNameLabel);

		bankNameLabel1 = new JTextField();
		bankNameLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		bankNameLabel1.setBounds(160, 295, 250, 30);
		bankNameLabel1.setBackground(Color.black);
		bankNameLabel1.setForeground(Color.white);
		c.add(bankNameLabel1);

		mainBalanceLabel = new JLabel("Main Balance :");
		mainBalanceLabel.setBounds(0, 340, 150, 20);
		mainBalanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
		mainBalanceLabel.setHorizontalAlignment(JLabel.RIGHT);
		c.add(mainBalanceLabel);

		mainBalanceLabel1 = new JTextField();
		mainBalanceLabel1.setFont(new Font("Arial", Font.BOLD, 16));
		mainBalanceLabel1.setBounds(160, 335, 250, 30);
		mainBalanceLabel1.setBackground(Color.black);
		mainBalanceLabel1.setForeground(Color.white);
		c.add(mainBalanceLabel1);

		submitButton = new JButton("Submit");
		submitButton.setBounds(175, 390, 90, 30);
		submitButton.setBackground(Color.black);
		submitButton.setForeground(Color.white);
		c.add(submitButton);

		homeButton = new JButton("Home");
		homeButton.setBounds(30, 10, 70, 30);
		homeButton.setBackground(Color.black);
		homeButton.setForeground(Color.white);
		homeButton.setFont(new Font("Arial", Font.BOLD, 12));
		c.add(homeButton);

		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameLabel1.getText();
				int age = Integer.parseInt(ageLabel1.getText());
				String phoneNo = phoneNoLabel1.getText();
				String NIDno = NIDLabel1.getText();
				Long accNo = Long.parseLong(accNoLabel1.getText());
				String bankName = bankNameLabel1.getText();
				double mainBalance = Double.parseDouble(mainBalanceLabel1.getText());
				if (age >= RulesAndRegulations.ageLimit && mainBalance >= RulesAndRegulations.balanceLiminit) {
					
					try {
						Donor.DonorInfoStore(new Donor(name, age, NIDno, phoneNo, accNo, bankName, mainBalance));
						JOptionPane.showMessageDialog(null, "Input collected");
						JOptionPane.showMessageDialog(null, "Returning to the home page");
						dispose();
						HomeFrame frame = new HomeFrame();
						frame.setVisible(true);
						frame.setBounds(100, 100, 500, 650);
						frame.setResizable(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Invalid Input. Try again");
					}
				} else {
					int confirmTemp = JOptionPane.showConfirmDialog(null,
							"Zakat isn't mandatory, do you want to continue?", "Be careful", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (confirmTemp == JOptionPane.YES_OPTION) {
						
						try {
							Donor.DonorInfoStore(new Donor(name, age, NIDno, phoneNo, accNo, bankName, mainBalance));
							JOptionPane.showMessageDialog(null, "Input collected");
							JOptionPane.showMessageDialog(null, "Returning to the home page");
							dispose();
							HomeFrame frame = new HomeFrame();
							frame.setVisible(true);
							frame.setBounds(100, 100, 500, 650);
							frame.setResizable(false);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Invalid Input. Try again");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Input is not stored, returning to the home page");
						dispose();
						HomeFrame frame = new HomeFrame();
						frame.setVisible(true);
						frame.setBounds(100, 100, 500, 650);
						frame.setResizable(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
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
		DonorFrame frame = new DonorFrame();
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
