package edu.project1;

import java.util.Random;

public class Dictionary {
    private static final String[] WORDS = {
        "blue", "word", "keyboard", "gravity", "road", "math"
    };

    private Dictionary() {
    }

    public static String getWord() {
        var random = new Random();

        var index = random.nextInt(WORDS.length);

        return WORDS[index];
    }
}
