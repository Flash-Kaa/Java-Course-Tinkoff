package edu.hw4.task13;

import edu.hw4.Animal;
import java.util.List;

public class Task13 {
    private Task13() {
    }

    // Список животных, имена которых состоят из более чем двух слов
    public static List<Animal> getAnimalsWithNamesContainingMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(x -> x.name().split("\\s+").length > 2)
            .toList();
    }
}
