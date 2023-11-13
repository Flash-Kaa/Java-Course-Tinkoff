package edu.hw4.task16;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public class Task16 {
    private Task16() {
    }

    // Список животных, отсортированный по виду, затем по полу, затем по имени
    public static List<Animal> sortAnimalsBySpeciesGenderName(List<Animal> animals) {
        return animals.stream()
            .sorted(
                Comparator.comparing(Animal::type)
                    .thenComparing(Animal::sex)
                    .thenComparing(Animal::name)
            )
            .toList();
    }
}
