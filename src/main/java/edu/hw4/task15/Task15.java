package edu.hw4.task15;

import edu.hw4.Animal;
import java.util.List;

public class Task15 {
    private Task15() {
    }

    // Найти суммарный вес животных каждого вида, которым от k до l лет
    public static Integer getTotalWeightBySpeciesInAgeRange(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(
                a -> a.age() >= k && a.age() <= l
            )
            .reduce(
                0, (acc, a) -> acc + a.weight(), Integer::sum
            );
    }
}
