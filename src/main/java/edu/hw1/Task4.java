package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        var strLen = str.length();
        var sb = new StringBuilder();

        for (var i = 0; i < strLen; i += 2) {

            if (i < strLen - 1) {
                sb.append(str.charAt(i + 1));
            }

            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
