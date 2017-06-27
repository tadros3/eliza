import java.util.Scanner;

public class TherapySession {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Therapist eliza = new Therapist();
		int count = 0;
		String input = "";
		System.out.println("Welcome to your therapy session! You can call me Dr. Eliza. What would you like to talk about?");
		input = keyboard.nextLine();
		while (!input.equals("q")) {
			if (count % 2 == 0) {
				System.out.println(eliza.qualify(input));
			} else {
				System.out.println(eliza.hedge());
			}
			count++;
			input = keyboard.nextLine();
		}
	}

}
