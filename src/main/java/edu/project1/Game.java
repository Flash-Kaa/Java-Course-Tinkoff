package edu.project1;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static final String EXIT_PHRASE = "to exit";
    private static final int MIN_WORD_LEN = 3;
    private final String word;
    private final char[] userSequence;
    private final int maxMistakesAllowed;
    private int mistakeCount = 0;

    public Game(int maxMistakesAllowed) {
        if (maxMistakesAllowed <= 0) {
            throw new IllegalArgumentException();
        }

        this.maxMistakesAllowed = maxMistakesAllowed;
        word = Dictionary.getWord().toLowerCase();
        int wordLen = word.length();

        if (wordLen < MIN_WORD_LEN) {
            throw new IllegalWordException(word);
        }

        userSequence = new char[wordLen];
        Arrays.fill(userSequence, '*');
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void play() {
        Scanner inputReader = new Scanner(System.in);

        while (true) {
            String input = getInputOrNull(inputReader);

            if (input == null || input.equalsIgnoreCase(EXIT_PHRASE)) {
                break;
            }

            if (input.length() != 1) {
                continue;
            }

            char charInput = input.charAt(0);
            SessionResult result = ResultUtils.getIntermediateResult(
                word, userSequence, charInput, maxMistakesAllowed, mistakeCount
            );

            if (result instanceof SessionResult.FailedGuess) {
                mistakeCount++;
            } else {
                HiddenWordUtils.openLettersInSequence(userSequence, word, charInput);
            }

            System.out.println(result.message());
            System.out.println();
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private String getInputOrNull(Scanner inputReader) {
        System.out.println("The word: " + new String(userSequence));
        System.out.println();

        SessionResult result = ResultUtils.getFinalResultOrNull(word, userSequence, maxMistakesAllowed, mistakeCount);

        if (result != null) {
            System.out.println(result.message());
            return null;
        }

        System.out.println("Guess a letter:");

        return inputReader.nextLine().toLowerCase();
    }
}
