package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        int strLength = str.length();
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < strLength; i += 2) {
            if (i < strLength - 1) {
                resultString.append(str.charAt(i + 1));
            }

            resultString.append(str.charAt(i));
        }

        return resultString.toString();
    }
}
