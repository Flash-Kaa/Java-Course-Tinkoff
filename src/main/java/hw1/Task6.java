package hw1;

import java.util.Comparator;
import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int number) {
        if (number > 9999 || number < 1000 || number % 1111 == 0) {
            throw new IllegalArgumentException();
        }

        var cycle = 0;
        var curNum = number;

        while (curNum != 6174) {
            cycle++;

            var decreasingNumber = cutNumberWithSort(curNum, true);
            var increasingNumber = cutNumberWithSort(curNum, false);

            curNum = decreasingNumber - increasingNumber;
        }

        return cycle;
    }

    private final static Comparator<Integer> DECREASING_COMPORATOR =
        (firstValue, secondValue) -> -Integer.compare(firstValue, secondValue);

    @SuppressWarnings("MagicNumber")
    private static int cutNumberWithSort(int number, boolean isDecreasing) {
        var res = new Integer[4];

        for (var i = 0; i < res.length; i++) {
            res[i] = (int) (number / Math.pow(10, 3 - i) % 10);
        }

        Arrays.sort(res, isDecreasing ? DECREASING_COMPORATOR : null);

        var resN = 0;

        for (var i = 0; i < res.length; i++) {
            resN += (int) (res[i] * Math.pow(10, 3 - i));
        }

        return resN;
    }
}
