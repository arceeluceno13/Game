package classes;
import java.util.Scanner;
public class HangmanGame {
        protected static final String[] WORDS = {"JAVA", "PYTHON", "COMPUTER", "PROGRAMMING", "ALGORITHM", "DEVELOPER", "JHENESIS", "ARCEE", "IAN VERGEL PASTOR"};
        protected static final int MAX_ATTEMPTS = 6;
        protected static final char HIDDEN_CHAR = '_';

        protected String chosenWord;
        protected char[] guessedLetters;
        protected int attemptsLeft;

        public HangmanGame(String chosenWord, char[] guessedLetters, int attemptsLeft) {
            this.chosenWord = chosenWord;
            this.guessedLetters = guessedLetters;
            this.attemptsLeft = attemptsLeft;
        }

        public HangmanGame() {
            chosenWord = WORDS[(int) (Math.random() * WORDS.length)];
            guessedLetters = new char[chosenWord.length()];
            for (int i = 0; i < guessedLetters.length; i++) {
                guessedLetters[i] = HIDDEN_CHAR;
            }
            attemptsLeft = MAX_ATTEMPTS;
        }

        public void play() {
            Scanner scanner = new Scanner(System.in);
            while (attemptsLeft > 0 && containsHiddenCharacters()) {
                displayGameStatus();
                System.out.print("Enter a letter: ");
                char guessedLetter = scanner.nextLine().toUpperCase().charAt(0);
                checkLetter(guessedLetter);
            }
            scanner.close();

            if (!containsHiddenCharacters()) {
                System.out.println("Congratulations! You guessed the word: " + chosenWord);
            } else {
                System.out.println("Sorry, you're out of attempts! The word was: " + chosenWord);
            }
        }

        public boolean containsHiddenCharacters() {
            for (char letter : guessedLetters) {
                if (letter == HIDDEN_CHAR) {
                    return true;
                }
            }
            return false;
        }

        public void displayGameStatus() {
            System.out.println("\nAttempts left: " + attemptsLeft);
            System.out.print("Current word: ");
            for (char letter : guessedLetters) {
                System.out.print(letter + " ");
            }
            System.out.println();
        }

        public void checkLetter(char letter) {
            boolean found = false;
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    found = true;
                }
            }
            if (!found) {
                attemptsLeft--;
                System.out.println("Letter '" + letter + "' is not in the word.");
            }
        }

}
