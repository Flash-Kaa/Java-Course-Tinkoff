package edu.hw3.task3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(T[] input) {
        Map<T, Integer> map = new HashMap<>();

        for (T i : input) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }
}
