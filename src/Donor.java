import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Donor extends Person implements RulesAndRegulations {
	private long accNo; // NEW
	private String bankName; // NEW
	private double mainBalance;
	private int age;

	public Donor(String name, int age, String nidNo, String phoneNo, long accNo, String bankName, double mainBalance)
			throws InvalidAgeException {
		super(name, nidNo, phoneNo);
		if (age > 0) {
			this.accNo = accNo;
			this.bankName = bankName;
			this.mainBalance = mainBalance;
			this.age = age;
		} else {
			throw new InvalidAgeException(age);
		}
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getMainBalance() {
		return mainBalance;
	}

	public int getAge() {
		return age;
	}

	public double zakatAmountCounter(double amount) {
		return (this.mainBalance * zakatPercentage);
	}

	public static void DonorInfoStore(Donor d) throws IOException, InvalidAgeException {
		FileWriter file = new FileWriter("Donor information.txt", true);
		PrintWriter write = new PrintWriter(file, true);
		FileWriter file1 = new FileWriter("Donor main balance.txt", true);
		PrintWriter write1 = new PrintWriter(file1, true);
		write.println(d.getName() + "\t" + d.getNidNo() + "\t" + d.getAge() + "\t" + d.getPhoneNo() + "\t"
				+ d.getAccNo() + "\t" + d.getBankName() + "\t" + d.getMainBalance());
//		write.println(d.toString());

		write1.println(d.getMainBalance());
		write.close();
		write1.close();
	}

	@Override
	public String toString() {
		return "" + super.getName() + "\t" + super.getNidNo() + "\t" + getAge() + "\t" + getPhoneNo() + "\t"
				+ getAccNo() + "\t" + getBankName() + "\t" + getMainBalance();
	}
}
