package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;

public class Task3 {
    private final static DateTimeFormatter[] FORMATTERS = new DateTimeFormatter[] {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("dd-MM-yy")
    };
    private final static int COUNT_NUMBERS_IN_DATE = 3;

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String input) {
        String inputForChange = input.replace("/", "-");

        if (inputForChange.contains("-")) {
            String[] s = inputForChange.split("-");
            if (s.length == COUNT_NUMBERS_IN_DATE && Arrays.stream(s).allMatch(Task3::isInteger)) {
                for (int i = 0; i < s.length; i++) {
                    addZero(s, i);
                }

                inputForChange = String.join("-", s);
            }
        }

        for (DateTimeFormatter formatter : FORMATTERS) {
            Optional<LocalDate> date = tryParse(inputForChange, formatter);
            if (date.isPresent()) {
                return date;
            }
        }

        Optional<LocalDate> result = Optional.empty();

        switch (input) {
            case "today":
                result = Optional.of(LocalDate.now());
                break;
            case "tomorrow":
                result = Optional.of(LocalDate.now().plusDays(1));
                break;
            case "yesterday":
                result = Optional.of(LocalDate.now().minusDays(1));
                break;
            default:
                if (inputForChange.endsWith("ago")) {
                    result = Optional.of(LocalDate.now().minusDays(getIntegerFromString(inputForChange)));
                }
        }

        return result;
    }

    private static Optional<LocalDate> tryParse(String string, DateTimeFormatter formatter) {
        try {
            return Optional.of(LocalDate.parse(string, formatter));
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    private static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static void addZero(String[] split, int index) {
        if (split[index].length() == 1) {
            split[index] = "0" + split[index];
        }
    }

    private static int getIntegerFromString(String input) {
        int index = 0;

        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            index++;
        }

        return Integer.parseInt(input.substring(0, index));
    }
}
