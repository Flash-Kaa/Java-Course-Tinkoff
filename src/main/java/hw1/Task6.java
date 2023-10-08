package hw1;

import org.intellij.lang.annotations.MagicConstant;
import java.util.Arrays;
import java.util.Comparator;

public class Task6 {
    private Task6() {
    }

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

    private static Comparator<Integer> decreasingComporator =
        (firstValue, secondValue) -> -Integer.compare(firstValue, secondValue);

    @MagicConstant
    private static int cutNumberWithSort(int number, boolean isDecreasing) {
        var res = new Integer[4];

        for (var i = 0; i < res.length; i++) {
            res[i] = (int) (number / Math.pow(10, 3 - i) % 10);
        }

        Arrays.sort(res, isDecreasing ? decreasingComporator : null);

        var resN = 0;

        for (var i = 0; i < res.length; i++) {
            resN += (int) (res[i] * Math.pow(10, 3 - i));
        }

        return resN;
    }
}
