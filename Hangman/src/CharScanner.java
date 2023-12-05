import java.util.Scanner;

public class CharScanner {
	
    public char getInput(Scanner charScanner) {
        char c;
        do {
            System.out.println("Your guess: ");
            String input = charScanner.next();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only one character.");
            } else {
                c = Character.toUpperCase(input.charAt(0));
                break;
            }
        } while (true);

        return c;
    }
}
