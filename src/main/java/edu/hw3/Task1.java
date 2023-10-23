package edu.hw3;

public class Task1 {
    private Task1() {
    }

    private final static int COUNT_WORDS_IN_ALPHABET = 26;

    public static String atbash(String line) {
        var mirroringString = new StringBuilder();

        for (var i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            char addToLine;

            if (!Character.isLetter(symbol)) {
                addToLine = symbol;
            } else {
                var firstLetterInAlphabet = Character.isLowerCase(symbol) ? 'a' : 'A';
                addToLine = (char) (2 * firstLetterInAlphabet + COUNT_WORDS_IN_ALPHABET - 1 - symbol);
            }

            mirroringString.append(addToLine);
        }

        return mirroringString.toString();
    }
}
