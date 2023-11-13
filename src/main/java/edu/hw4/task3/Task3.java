package edu.hw4.task3;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    private Task3() {
    }

    // Сколько животных каждого вида
    public static Map<Animal.Type, Integer> countTypes(List<Animal> animals) {
        return animals.stream()
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.collectingAndThen(
                        Collectors.counting(),
                        Long::intValue
                    )
                )
            );
    }
}
