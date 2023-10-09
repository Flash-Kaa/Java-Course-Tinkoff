package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;

public class Task6 {
    private Task6() {
    }

    private static final int DIGIT_COUNT = 4;
    private static final int MAX_NUMBER = 9999;
    private static final int MIN_NUMBER = 1000;
    private static final int TARGET_NUMBER = 6174;
    private static final int MUST_NOT_BE_DIVISOR = 1111;
    private static final int DIVISOR_CHANGES_DIGIT_OF_NUMBER = 10;

    private final static Comparator<Integer> DECREASING_COMPARATOR =
        (firstValue, secondValue) -> -Integer.compare(firstValue, secondValue);

    public static int countK(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER || number % MUST_NOT_BE_DIVISOR == 0) {
            throw new IllegalArgumentException();
        }

        int cycle = 0;
        int numForChange = number;

        while (numForChange != TARGET_NUMBER) {
            int decreasingNumber = orderDigitsInNumber(numForChange, true);
            int increasingNumber = orderDigitsInNumber(numForChange, false);

            cycle++;
            numForChange = decreasingNumber - increasingNumber;
        }

        return cycle;
    }

    private static int orderDigitsInNumber(int number, boolean isDecreasing) {
        Integer[] resultDigits = new Integer[DIGIT_COUNT];
        int resNumber = 0;

        for (int i = 0; i < resultDigits.length; i++) {
            int partOfNumber = (int) (number / Math.pow(DIVISOR_CHANGES_DIGIT_OF_NUMBER, DIGIT_COUNT - 1 - i));
            resultDigits[i] = partOfNumber % DIVISOR_CHANGES_DIGIT_OF_NUMBER;
        }

        Arrays.sort(resultDigits, isDecreasing ? DECREASING_COMPARATOR : null);

        for (int i = 0; i < resultDigits.length; i++) {
            resNumber += (int) (resultDigits[i] * Math.pow(DIVISOR_CHANGES_DIGIT_OF_NUMBER, DIGIT_COUNT - 1 - i));
        }

        return resNumber;
    }
}
