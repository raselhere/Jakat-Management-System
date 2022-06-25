import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Distribution {
	private static double totalAmount = 0; // total

	public static void setTotalAmount(double totalAmount) {
		Distribution.totalAmount = totalAmount;
	}

	public static void distributeToDonees() throws IOException {
		Distribution.setTotalAmount(Collection.amountFromFile());
		double temp;
		double temp1 = 0;
		try {
			File file = new File("Donee main balance.txt");
			Scanner scan = new Scanner(file);
			FileWriter file1 = new FileWriter("Donee new balance.txt");
			PrintWriter write1 = new PrintWriter(file1, true);
			while (scan.hasNext()) {
				temp = scan.nextDouble(); // old
				temp1 = temp + perPersonDonation(Donee.DoneeCounterMethod()); // new balance
				write1.println(temp1);
			}
		} catch (Exception ex) {
			System.out.print("Error Occured");
		}

		double temp2;
		double temp3 = 0;
		try {
			File file1 = new File("Donor main balance.txt");
			Scanner scan1 = new Scanner(file1);
			FileWriter file2 = new FileWriter("Donor new balance.txt");
			PrintWriter write2 = new PrintWriter(file2, true);
			while (scan1.hasNext()) {
				temp2 = scan1.nextDouble();
				temp3 = (temp2 - temp2 * RulesAndRegulations.zakatPercentage); // new balance
				write2.println(temp3);
			}
		} catch (Exception ex) {
			System.out.print("Error Occured");
		}

	}

	public static double perPersonDonation(int doneeNumber) {
		return (double) (totalAmount / (double) doneeNumber);
	}
}
