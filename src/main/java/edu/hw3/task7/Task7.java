package edu.hw3.task7;

import java.util.Comparator;

public class Task7 {
    private Task7() {
    }

    public static <T extends Comparable<T>> Comparator<T> getNullComparator() {
        return (T a, T b) -> {
            if (a == null && b == null) {
                return 0;
            }

            if (a == null) {
                return -1;
            }

            if (b == null) {
                return 1;
            }

            return a.compareTo(b);
        };
    }
}
