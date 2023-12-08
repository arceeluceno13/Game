package classes;
import java.util.Scanner;
public class RockPaperScissors {
    private final String[] choices = {"ROCK", "PAPER", "SCISSORS"};

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Enter your choice: ROCK, PAPER, or SCISSORS");

        String userChoice = scanner.nextLine().toUpperCase();
        if (userChoice.equals("ROCK") || userChoice.equals("PAPER") || userChoice.equals("SCISSORS")) {
            int computerIndex = (int) (Math.random() * choices.length);
            String computerChoice = choices[computerIndex];

            System.out.println("Computer chooses: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("ROCK") && computerChoice.equals("SCISSORS")) ||
                    (userChoice.equals("PAPER") && computerChoice.equals("ROCK")) ||
                    (userChoice.equals("SCISSORS") && computerChoice.equals("PAPER"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        } else {
            System.out.println("Invalid choice. Please enter ROCK, PAPER, or SCISSORS.");
        }

        scanner.close();
    }
}