package edu.hw5.task4;

import java.util.regex.Pattern;

public class Task4 {
    private final static String SPECIAL_CHARACTERS = "[~!@#\\\\$%^&*|]";

    private Task4() {
    }

    public static boolean checkPasswordCorrectness(String password) {
        return Pattern.compile(SPECIAL_CHARACTERS).matcher(password).find();
    }
}
