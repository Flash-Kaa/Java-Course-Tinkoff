package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(T[] input) {
        var map = new HashMap<T, Integer>();

        for (var i : input) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.replace(i, map.get(i) + 1);
            }
        }
        return map;
    }
}
