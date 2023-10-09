package edu.hw1;

public class Task1 {
    private Task1() {
    }

    private static final int SECONDS_IN_MINUTE = 60;
    private static final String SEPARATION_CHARACTER = ":";

    public static int minutesToSeconds(String time) {

        if (!checkCorrectness(time)) {
            return -1;
        }

        String[] timeParts = time.split(SEPARATION_CHARACTER);
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);

        return minutes * SECONDS_IN_MINUTE + seconds;
    }

    private static boolean checkCorrectness(String time) {
        String[] timeParts = time.split(SEPARATION_CHARACTER);

        if (timeParts.length != 2) {
            return false;
        }

        for (String part : timeParts) {
            for (int charIndex = 0; charIndex < part.length(); charIndex++) {
                char symbol = part.charAt(charIndex);

                if (!Character.isDigit(symbol)) {
                    return false;
                }
            }
        }

        return Integer.parseInt(timeParts[1]) < SECONDS_IN_MINUTE;
    }
}
