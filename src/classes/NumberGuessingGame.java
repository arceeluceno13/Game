package classes;
import java.util.Scanner;

public class NumberGuessingGame {

    private int randomNumber;
    private int attempts;
    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public NumberGuessingGame() {
        randomNumber = (int) (Math.random() * (RANGE_MAX - RANGE_MIN + 1)) + RANGE_MIN;
        attempts = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX);

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine(); // Consume newline left after nextInt()

            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (attempts >= MAX_ATTEMPTS) {
            System.out.println("Sorry, you've run out of attempts! The number was: " + randomNumber);
        }

        scanner.close();
    }
}
