package edu.hw1;

public class Task2 {
    private Task2() {
    }

    private static final int DIVISOR_THAT_CHANGES_DIGIT_OF_NUMBER = 10;

    public static int countDigits(int number) {
        int count = 0;
        int numForChange = number;

        do {
            count++;
            numForChange /= DIVISOR_THAT_CHANGES_DIGIT_OF_NUMBER;
        } while (numForChange != 0);

        return count;
    }
}
