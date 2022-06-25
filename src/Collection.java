import java.io.File;
import java.util.Scanner;

public class Collection {
	public static double totalAmount = 0;

	public static void setTotalAmount(double totalAmount) {
		Collection.totalAmount += totalAmount;
	}

	public static double amountFromFile() {
		double temp = 0;
		try {
			File file = new File("Donor main balance.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				double tempMoney = scan.nextDouble();
				temp += zakatAmount(tempMoney);

			}
		} catch (Exception ex) {
			System.out.println("Error Occured @ collection class");
		}
		totalAmount = temp;
		return temp;

	}

	// Collection.setTotalAmount(zakatCounter(Raju));
	public static double zakatAmount(double amount) {
		return (amount * RulesAndRegulations.zakatPercentage);
	}
}
