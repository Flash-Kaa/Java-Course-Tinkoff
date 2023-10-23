package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class Task7 {
    private Task7() {
        var t = new TreeMap<String, String>();
    }

    public static <T extends Comparable<T>> Comparator<T> getNullComparator() {
        return (T a, T b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        };
    }
}
