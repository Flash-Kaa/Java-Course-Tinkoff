package edu.hw3.task1;

public class Task1 {
    private final static int COUNT_WORDS_IN_ALPHABET = 26;

    private Task1() {
    }

    public static String atbash(String line) {
        StringBuilder mirroringString = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            char addToLine;

            if (!Character.isLetter(symbol)) {
                addToLine = symbol;
            } else {
                char firstLetterInAlphabet = Character.isLowerCase(symbol) ? 'a' : 'A';
                addToLine = (char) (2 * firstLetterInAlphabet + COUNT_WORDS_IN_ALPHABET - 1 - symbol);
            }

            mirroringString.append(addToLine);
        }

        return mirroringString.toString();
    }
}
