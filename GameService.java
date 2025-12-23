import java.util.Random;

public class GameService {
    private static final String[] DEFAULT_WORDS = {
        "coffee", "family", "garden", "school", "street", "window", "pillow"
    };

    private Word currentWord;
    private int remainingAttempts;
    private boolean[] attemptedLetters;

    public GameService() {
        this(DEFAULT_WORDS, 6);
    }

    public GameService(String[] wordPool, int maxAttempts) {
        this.currentWord = selectRandomWord(wordPool);
        this.remainingAttempts = maxAttempts;
        this.attemptedLetters = new boolean[26];
    }

    private Word selectRandomWord(String[] wordPool) {
        Random random = new Random();
        int index = random.nextInt(wordPool.length);
        return new Word(wordPool[index]);
    }

    public boolean isGuessValid(String guessInput) {
        if (guessInput == null || guessInput.length() != 1) {
            return false;
        }
        char letter = guessInput.charAt(0);
        return Character.isLetter(letter);
    }

    public boolean isLetterAlreadyTried(char letter) {
        int index = letter - 'a';
        if (index < 0 || index >= attemptedLetters.length) {
            return false;
        }
        return attemptedLetters[index];
    }

    public boolean processGuess(char letter) {
        int index = letter - 'a';
        if (index >= 0 && index < attemptedLetters.length) {
            attemptedLetters[index] = true;
        }
        boolean isCorrect = currentWord.updateGuessedState(letter);
        if (!isCorrect) {
            remainingAttempts--;
        }
        return isCorrect;
    }

    public String getCurrentProgress() {
        return currentWord.getDisplayState();
    }

    public boolean hasAttemptsLeft() {
        return remainingAttempts > 0;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public boolean isWordGuessed() {
        return currentWord.isFullyGuessed();
    }

    public String getActualWord() {
        return currentWord.getActualWord();
    }
}
