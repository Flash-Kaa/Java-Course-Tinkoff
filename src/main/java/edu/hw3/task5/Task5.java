package edu.hw3.task5;

import java.util.Arrays;

public class Task5 {
    private static final String DECREASING = "DESC";
    private static final String INCREASING = "ASC";

    private Task5() {
    }

    public static Object[] parseContacts(String[] peoples, String order) {
        if (!order.equalsIgnoreCase(INCREASING)
            && !order.equalsIgnoreCase(DECREASING)) {
            throw new IllegalArgumentException();
        }

        if (peoples == null) {
            return new Object[0];
        }

        return Arrays.stream(peoples)
            .sorted((a, b) -> order.equals(INCREASING) ? flipString(a).compareTo(flipString(b))
                : flipString(b).compareTo(flipString(a)))
            .toArray();
    }

    private static String flipString(String line) {
        if (line == null) {
            throw new IllegalArgumentException();
        }

        String[] parts = line.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = parts.length - 1; i >= 0; i--) {
            sb.append(parts[i]);
        }

        return sb.toString();
    }
}
