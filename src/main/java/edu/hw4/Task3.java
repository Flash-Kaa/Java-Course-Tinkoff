package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static Map<Animal.Type, Integer> countTypes(List<Animal> animals) {
        var map = new HashMap<Animal.Type, Integer>();

        for (var i : animals) {
            if (!map.containsKey(i.type())) {
                map.put(i.type(), 1);
            } else {
                map.replace(i.type(), map.get(i.type()) + 1);
            }
        }

        return map;
    }
}
