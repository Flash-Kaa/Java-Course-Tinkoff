package hw_1;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        return arr1.length > 0 && arr2.length > 0
            && findMinValue(arr1) > findMinValue(arr2)
            && findMaxValue(arr1) < findMaxValue(arr2);
    }

    private static int findMinValue(int[] array) {
        var min = Integer.MAX_VALUE;

        for (var i : array) {
            min = Integer.min(min, i);
        }

        return min;
    }

    private static int findMaxValue(int[] array) {
        var max = Integer.MIN_VALUE;

        for (var i : array) {
            max = Integer.max(max, i);
        }

        return max;
    }
}
