
public class InvalidAgeException extends Exception {
	private int age;

	public InvalidAgeException(int age) {
		super("Invalid age: " + age);

	}
}
