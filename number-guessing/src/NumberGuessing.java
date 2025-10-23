import java.util.*;

public class NumberGuessing {
    // Game constants
    private static final int NUM_DIGITS = 3;
    private static final int MAX_GUESSES = 10;

    public static void main(String[] args) {
        System.out.println("""
                Bagels, a deductive logic game.
                By Al Sweigart (Java version)
                
                I am thinking of a %d-digit number with no repeated digits.
                Try to guess what it is. Here are some clues:
                When I say:    That means:
                  Pico         One digit is correct but in the wrong position.
                  Fermi        One digit is correct and in the right position.
                  Bagels       No digit is correct.
                """.formatted(NUM_DIGITS));

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {  // Main game loop
            String secretNum = getSecretNum(random);
            System.out.println("I have thought up a number.");
            System.out.println("You have " + MAX_GUESSES + " guesses to get it.");

            int numGuesses = 1;
            while (numGuesses <= MAX_GUESSES) {
                System.out.print("Guess #" + numGuesses + ": ");
                String guess = scanner.nextLine();

                if (guess.length() != NUM_DIGITS || !guess.matches("\\d+")) {
                    System.out.println("Invalid input. Enter " + NUM_DIGITS + " digits.");
                    continue;
                }

                String clues = getClues(guess, secretNum);
                System.out.println(clues);
                numGuesses++;

                if (guess.equals(secretNum)) {
                    break;  // Player got it right
                }

                if (numGuesses > MAX_GUESSES) {
                    System.out.println("You ran out of guesses. The number was " + secretNum + ".");
                }
            }

            System.out.print("Do you want to play again? (yes or no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.startsWith("y")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
    }

    // --- Helper methods ---
    private static String getSecretNum(Random random) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits, random);

        StringBuilder secretNum = new StringBuilder();
        for (int i = 0; i < NUM_DIGITS; i++) {
            secretNum.append(digits.get(i));
        }
        return secretNum.toString();
    }

    private static String getClues(String guess, String secretNum) {
        if (guess.equals(secretNum)) {
            return "You got it!";
        }

        List<String> clues = new ArrayList<>();

        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            if (g == secretNum.charAt(i)) {
                clues.add("Fermi");
            } else if (secretNum.indexOf(g) != -1) {
                clues.add("Pico");
            }
        }

        if (clues.isEmpty()) {
            return "Bagels";
        }

        Collections.sort(clues);
        return String.join(" ", clues);
    }
}
