package edu.hw7.task4;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Task4 {
    private Task4() {
    }

    public static double calculatePi(int n) {
        int circleCount = 0;
        SecureRandom rand = new SecureRandom();

        for (int i = 0; i < n; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();

            if (x * x + y * y <= 1) {
                circleCount++;
            }
        }

        return 4.0 * circleCount / n;
    }

    public static double calculatePiMultiThread(int n, int totalThreadCount) {
        FutureTask<Double> r = new FutureTask<>(
            () -> calculatePi(n / totalThreadCount)
        );

        List<FutureTask<Double>> threads = Stream.generate(() -> r)
            .limit(totalThreadCount)
            .peek(x -> new Thread(x).start())
            .toList();

        return threads.stream()
            .map(
                x -> {
                    try {
                        return x.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            ).reduce(0.0, Double::sum);
    }

    public static void getAndPrintTimeStatistics(int n, int maxThreadsCount, int testCount) {
        String[] t = getTimeStatistics(n, maxThreadsCount, testCount);
        for (var i = 0; i < t.length; i++) {
            System.out.println((i + 1) + " : " + t[i]);
        }
    }

    private static String[] getTimeStatistics(int n, int maxThreadsCount, int testCount) {
        String[] results = new String[maxThreadsCount];

        for (var i = 0; i < maxThreadsCount; i++) {
            System.gc();
            long start = System.nanoTime();
            double resSumPI = 0;
            for(int j = 0; j < testCount; j++) {
                resSumPI += calculatePiMultiThread(n, i + 1);
            }

            long time = (System.nanoTime() - start) / testCount;
            double inaccuracy = Math.abs(Math.PI - resSumPI / testCount);
            results[i] = String.format("time: %s, inaccuracy: %s", time, inaccuracy);
        }

        return results;
    }

    public static void main(String[] args) {
        getAndPrintTimeStatistics(1000000, 50, 5);
    }
}
