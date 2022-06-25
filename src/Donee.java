
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Donee extends Person {
	private long accNo; // NEW
	private int age;
	private String bankName; // NEW
	private double mainBalance;
	private static int doneeCounter = 0;

	public Donee(String name, int age, String nidNo, String phoneNo, long accNo, String bankName, double mainBalance)
			throws InvalidAgeException {
		super(name, nidNo, phoneNo);
		if (age > 0) {
			this.accNo = accNo;
			this.bankName = bankName;
			this.mainBalance = mainBalance;
			this.age = age;
			doneeCounter++; // 100
		} else {
			throw new InvalidAgeException(age);
		}

	}

	public long getAccNo() {
		return accNo;
	}

	public String getBankName() {
		return bankName;
	}

	public double getMainBalance() {
		return mainBalance;
	}

	public void setMainBalance(double amount) {
		this.mainBalance += amount;
	}

	public static int getDoneeCounter() {
		return doneeCounter;
	}

	public boolean equals(Object m) {
		if (this.accNo == ((Donee) m).accNo) {
			return true;
		} else
			return false;
	}

	public static void DoneeInfoStore(Donee d) throws IOException, InvalidAgeException {
		FileWriter file = new FileWriter("Donee information.txt", true);
		PrintWriter write = new PrintWriter(file, true);
		FileWriter file1 = new FileWriter("Donee main balance.txt", true);
		PrintWriter write1 = new PrintWriter(file1, true);
		FileWriter file2 = new FileWriter("Donee NID Number.txt", true);
		PrintWriter write2 = new PrintWriter(file2, true);

		write.println(d.getName() + "\t" + d.getNidNo() + "\t" + d.getAge() + "\t" + d.getPhoneNo() + "\t"
				+ d.getAccNo() + "\t" + d.getBankName() + "\t" + d.getMainBalance());
		write1.println(d.getMainBalance());
		write2.println(d.getNidNo());
		write.close();
		write1.close();
		write2.close();
	}

	public int getAge() {
		return age;
	}

	public static int DoneeCounterMethod() {
		int i = 0;
		try {
			File file = new File("Donee NID Number.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				long tempMoney = scan.nextLong();
				i++;

			}
		} catch (Exception ex) {
			System.out.println("Error Occured");
		}
		return i; // donee count
	}

	@Override
	public String toString() {
		return "Donee [accNo=" + accNo + ", bankName=" + bankName + ", mainBalance=" + mainBalance + "]";
	}
}
