package edu.hw1;

public class Task2 {
    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int number) {
        var count = 0;
        var numForChange = number;

        do {
            count++;
            numForChange /= 10;
        } while (numForChange != 0);

        return count;
    }
}
