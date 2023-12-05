import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {

	static int chances = 8;
	static int totalMatches = 0; // total matches found
	static ArrayList<Character> allGuesses = new ArrayList<Character>(); // all previous guesses

	public static void main(String[] args) {
		// Greeting Message
		System.out.println("Welcome to Hangman!");

		// Pick a random word from the list
		PickAWord wordPicker = new PickAWord();
		String word = wordPicker.getRandomWord(new String[] {
		                                                     "LION", "TIGER", "BEAR", "ELEPHANT", "GIRAFFE",
		                                                     "ZEBRA", "KANGAROO", "PANDA", "CHEETAH", "LEOPARD",
		                                                     "HIPPOPOTAMUS", "RHINOCEROS", "GORILLA", "ORANGUTAN", "MONKEY",
		                                                     "CHIMPANZEE", "KOALA", "KIWI", "PENGUIN", "DOLPHIN",
		                                                     "WHALE", "SHARK", "OCTOPUS", "CROCODILE", "ALLIGATOR",
		                                                     "SNAKE", "LIZARD", "TURTLE", "FROG", "TOAD",
		                                                     "SALAMANDER", "NEWT", "OWL", "EAGLE", "HAWK",
		                                                     "FALCON", "PELICAN", "PIGEON", "PARROT", "TOUCAN",
		                                                     "PEACOCK", "OSTRICH", "EAGLE", "HUMMINGBIRD", "ROBIN",
		                                                     "SPARROW", "PUFFIN", "COW", "HORSE", "PIG",
		                                                     "GOAT", "SHEEP", "CHICKEN", "DUCK", "GOOSE",
		                                                     "TURKEY", "PHEASANT", "SWAN", "FLAMINGO", "PELICAN",
		                                                     "HEN", "COCKATOO", "RABBIT", "HARE", "SQUIRREL",
		                                                     "CHIPMUNK", "BEAVER", "RACCOON", "FOX", "WOLF",
		                                                     "COYOTE", "JACKAL", "BAT", "FLYING FOX", "MOUSE",
		                                                     "RAT", "GERBIL", "HAMSTER", "GUINEA PIG", "CHINCHILLA",
		                                                     "PORCUPINE", "HEDGEHOG", "ARMADILLO", "ANTEATER", "SLOTH",
		                                                     "KIWI", "PLATYPUS", "KANGAROO", "WALLABY", "KOALA",
		                                                     "WOMBAT", "DINGO", "TASMANIAN DEVIL", "KOOKABURRA", "CASSOWARY",
		                                                     "COBRA", "MAMBA", "PYTHON", "VIPER", "BOA CONSTRICTOR"
		}
);

		playGame(word);
	}

	public static void playGame(String word) {
		// Hide the word
		HideWord wordHider = new HideWord();
		char[] hiddenWord = wordHider.hideWord(word.length());
		Scanner inputScanner = new Scanner(System.in);

		// Looping for each round
		do {
			// Display updated word status
			System.out.println("The word now looks like this: " + String.valueOf(hiddenWord));

			// When left 2-8 chance
			if (chances != 1) {
				System.out.println("You have " + chances + " guesses left.");
			
			// When left 1 chance
			} else {
				System.out.println("You have only one guess left.");
			}
			
			// Display attempted letters
			if (!allGuesses.isEmpty()) {
				System.out.println("You've already used these letter(s): " + allGuesses);
			}

			CharScanner charScanner = new CharScanner();
			char guess = charScanner.getInput(inputScanner);

			// Check if the letter has been guessed before
			if (allGuesses.contains(guess)) {
				System.out.println("You've already guessed '" + guess + "'. Try again.");
				continue;
			}

			// Add the guessed letter to the list of used characters
			allGuesses.add(guess);

			checkMatch(word, guess, hiddenWord);

			// Print win game message
			if (totalMatches == word.length()) {
				YouWin(hiddenWord);
				return;
			}

		} while (chances > 0); // end when run out of chances

		inputScanner.close();

		// Print lose game message
		YouLose(word);
	}
	
	// Check if the input match the word
	public static void checkMatch(String word, char guess, char[] hiddenWord) {
		int matchCount = 0;

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);

			if (Character.toUpperCase(guess) == letter) {
				matchCount++;
				hiddenWord[i] = letter; // replace - with correct letter
			}
		}

		totalMatches += matchCount;

		if (matchCount > 0) {
			System.out.println("That guess is correct");
		} else {
			chances--;
			System.out.println("There are no " + guess + "'s in the word");
		}
	}

	// Win game message
	static void YouWin(char[] hiddenWord) {
		System.out.println("You guessed the word: " + String.valueOf(hiddenWord));
		System.out.println("You win.");
	}

	// Lost game message
	static void YouLose(String word) {
		System.out.println("You're completely hung.");
		System.out.println("The word was: " + word);
		System.out.println("You lose.");
	}

}
