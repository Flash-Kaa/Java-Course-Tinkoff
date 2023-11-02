package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private Task4() {
    }

    private final static String SPECIAL_CHARACTERS = "[~!@#\\$%^&*|]";

    public static boolean checkPasswordCorrectness(String password) {
        return Pattern.compile(SPECIAL_CHARACTERS).matcher(password).find();
    }
}
