public class Word {
    private String actualWord;
    private char[] guessedState;

    public Word(String actualWord) {
        this.actualWord = actualWord.toLowerCase();
        this.guessedState = new char[actualWord.length()];
        for (int i = 0; i < actualWord.length(); i++) {
            this.guessedState[i] = '_';
        }
    }

    public boolean updateGuessedState(char guessedLetter) {
        boolean isFound = false;
        for (int i = 0; i < actualWord.length(); i++) {
            if (actualWord.charAt(i) == guessedLetter) {
                guessedState[i] = guessedLetter;
                isFound = true;
            }
        }
        return isFound;
    }

    public String getDisplayState() {
        StringBuilder displayBuilder = new StringBuilder();
        for (int i = 0; i < guessedState.length; i++) {
            displayBuilder.append(guessedState[i]);
            if (i < guessedState.length - 1) {
                displayBuilder.append(' ');
            }
        }
        return displayBuilder.toString();
    }

    public boolean isFullyGuessed() {
        for (int i = 0; i < guessedState.length; i++) {
            if (guessedState[i] == '_') {
                return false;
            }
        }
        return true;
    }

    public String getActualWord() {
        return actualWord;
    }
}
