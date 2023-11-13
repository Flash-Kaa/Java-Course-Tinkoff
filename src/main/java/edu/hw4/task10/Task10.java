package edu.hw4.task10;

import edu.hw4.Animal;
import java.util.List;

public class Task10 {
    private Task10() {
    }

    // Список животных, возраст у которых не совпадает с количеством лап
    public static List<Animal> getAnimalsWithMismatchedAgeAndPaws(List<Animal> animals) {
        return animals.stream()
            .filter(x -> x.age() != x.paws())
            .toList();
    }
}


