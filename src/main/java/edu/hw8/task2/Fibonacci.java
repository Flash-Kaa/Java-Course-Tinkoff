package edu.hw8.task2;

public class Fibonacci {
    private static FixedThreadPool tp;

    private Fibonacci() {
    }

    public static void stopTP() {
        tp.close();
    }

    public static void getFirstNumbers(int n, int threadsCount, int[] result) {
        if (result.length < n) {
            throw new IllegalArgumentException();
        }

        tp = new FixedThreadPool(threadsCount);

        for (int i = 0; i < n; i++) {
            int finalI = i;
            tp.execute(() -> result[finalI] = get(finalI + 1));
        }
    }

    private static int get(int n) {
        int firstNum = 0;
        int secondNum = 1;
        int indexToCalculate = 2;

        while (indexToCalculate < n) {
            if (indexToCalculate++ % 2 == 0) {
                firstNum += secondNum;
            } else {
                secondNum += firstNum;
            }
        }

        return firstNum + secondNum;
    }
}
