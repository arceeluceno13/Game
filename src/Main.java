import classes.HangmanGame;
import classes.NumberGuessingGame;
import classes.RockPaperScissors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame hangman = new HangmanGame();
        NumberGuessingGame number = new NumberGuessingGame();
        RockPaperScissors rockpaperscissors = new RockPaperScissors();

        System.out.print("Pick a game from 1-3!: ");
        int game = scanner.nextInt();

        switch (game) {
            case 1:
                hangman.play();
                break;
            case 2:
                number.play();
                break;
            case 3:
                rockpaperscissors.playGame();
                break;
            default:
                System.out.println("Please pick from 1 - 3!");
        }
    }
}

//YAWA