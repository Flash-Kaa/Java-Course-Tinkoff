package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] firstInputArray, int[] secondInputArray) {
        return firstInputArray.length > 0 && secondInputArray.length > 0
            && findMinValueInArray(firstInputArray) > findMinValueInArray(secondInputArray)
            && findMaxValueInArray(firstInputArray) < findMaxValueInArray(secondInputArray);
    }

    private static int findMinValueInArray(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i : array) {
            min = Integer.min(min, i);
        }

        return min;
    }

    private static int findMaxValueInArray(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int i : array) {
            max = Integer.max(max, i);
        }

        return max;
    }
}
