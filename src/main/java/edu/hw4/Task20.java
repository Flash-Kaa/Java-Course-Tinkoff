package edu.hw4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task20 {
    private Task20() {
    }

    public static Map<String, String> getNamesAnimalsWithTheirErrorFields(Map<String, Set<ValidationError>> errors) {
        var result = new HashMap<String, String>();

        for (var key : errors.keySet()) {
            var errorFields = errors.get(key)
                .stream()
                .map(x -> x
                    .message()
                    .split(" ")[0])
                .collect(Collectors.joining(", "));
            result.put(key, errorFields);
        }

        return result;
    }
}
