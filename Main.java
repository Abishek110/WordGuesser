import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameService gameService = new GameService();
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Guess one letter at a time. You have limited attempts.");
        System.out.println("Good luck!\n");
        while (gameService.hasAttemptsLeft() && !gameService.isWordGuessed()) {
            System.out.println("Current word: " + gameService.getCurrentProgress());
            System.out.println("Attempts left: " + gameService.getRemainingAttempts());
            System.out.print("Enter your guess: ");
            String guessInput = scanner.nextLine().trim().toLowerCase();
            if (!gameService.isGuessValid(guessInput)) {
                System.out.println("Invalid input. Please enter a single letter.\n");
                continue;
            }
            char guessedLetter = guessInput.charAt(0);
            if (gameService.isLetterAlreadyTried(guessedLetter)) {
                System.out.println("You already tried that letter. Pick a different one.\n");
                continue;
            }
            boolean isCorrect = gameService.processGuess(guessedLetter);
            if (isCorrect) {
                System.out.println("Great! The letter \"" + guessedLetter + "\" is in the word.\n");
            } else {
                System.out.println("Sorry, the letter \"" + guessedLetter + "\" is not in the word.\n");
            }
        }
        if (gameService.isWordGuessed()) {
            System.out.println("Congratulations! You guessed the word: " + gameService.getActualWord());
        } else {
            System.out.println("Out of attempts! The word was: " + gameService.getActualWord());
        }
        scanner.close();
    }
}
