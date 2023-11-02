package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(String sequence, String subsequence) {
        String regex = ".*" + Pattern.quote(subsequence) + ".*";
        return Pattern.matches(regex, sequence);
    }
}
