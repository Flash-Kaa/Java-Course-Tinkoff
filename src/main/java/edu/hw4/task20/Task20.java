package edu.hw4.task20;

import edu.hw4.ValidationError;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task20 {
    private Task20() {
    }

    // Сделать результат предыдущего задания более читабельным:
    // вернуть имя и названия полей с ошибками, объединенные в строку
    public static Map<String, String> getNamesAnimalsWithTheirErrorFields(Map<String, Set<ValidationError>> errors) {
        Map<String, String> result = new HashMap<>();

        for (var key : errors.keySet()) {
            var errorFields = errors.get(key)
                .stream()
                .map(x -> x
                    .message()
                    .split("\\s+")[0]
                )
                .collect(Collectors.joining(", "));
            result.put(key, errorFields);
        }

        return result;
    }
}
