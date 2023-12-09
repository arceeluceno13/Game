import classes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame hangman = new HangmanGame();
        NumberGuessingGame number = new NumberGuessingGame();
        RockPaperScissors rockpaperscissors = new RockPaperScissors();

        System.out.println("Pick a mode.");
        System.out.println("1. If u want to play.");
        System.out.println("2. If u want to get Mean, Median, Mode.");
        int modes = scanner.nextInt();

        switch (modes) {
            case 1:
                System.out.println("\n\nPick a game from 1-3!");
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
                    default:
                        System.out.println("Please pick from 1 - 3!");
                }
                break;

            case 2:
                System.out.print("Enter the number of elements: ");
                int n = scanner.nextInt();

                double[] inputData = new double[n];
                System.out.println("Enter the elements:");
                for (int i = 0; i < n; i++) {
                    inputData[i] = scanner.nextDouble();
                }

                MeanMedianModeCalculator calculator = new MeanMedianModeCalculator(inputData);

                double mean = calculator.calculateMean();
                System.out.println("Mean: " + mean);

                double median = calculator.calculateMedian();
                System.out.println("Median: " + median);

                double[] mode = calculator.calculateMode();
                if (mode.length == 0) {
                    System.out.println("No mode found");
                } else {
                    System.out.print("Mode: ");
                    for (double value : mode) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Please pick from 1 - 3!");
        }
        scanner.close();
    }

}


//YAWA