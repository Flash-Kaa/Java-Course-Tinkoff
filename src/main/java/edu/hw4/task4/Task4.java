package edu.hw4.task4;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    private Task4() {
    }

    // У какого животного самое длинное имя
    public static Animal getAnimalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparing(Animal::name))
            .get();
    }
}
