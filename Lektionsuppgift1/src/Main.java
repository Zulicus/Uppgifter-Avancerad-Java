
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		// Preset Password
		String password = "Hej01!";
		System.out.println("Please enter password:");
		// For-loop that prevents more than three tries
		for (int tries = 3; tries > 0; tries--) {
			String input = scan.nextLine();
			Thread.sleep(500);
			if (passCheck(input, password)) {
				// If the password is correct this message is displayed and the loop brakes
				System.out.println("Password Confirmed, Welcome!");
				break;
			} else {
				// If the password is wrong and you don't have any tries left
				if (tries - 1 == 0) {
					System.out.println("Invalid Password, You have exceded your max tries");
				} else {
					// If the password is wrong it tells you that it's wrong and how many tries are
					// left
					System.out.println("Invalid Password, Try again.");
					Thread.sleep(500);
					System.out.println("you have " + (tries - 1) + " tries remaining.");
				}
			}
		}
		scan.close();
	}

	// Tests if the inputed string matches the password
	public static boolean passCheck(String input, String password) {
		return input.equals(password);
	}
}
