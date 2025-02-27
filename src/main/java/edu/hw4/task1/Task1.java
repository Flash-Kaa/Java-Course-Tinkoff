package edu.hw4.task1;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    private Task1() {
    }

    // Отсортировать животных по росту от самого маленького к самому большому
    public static List<Animal> sortByHeight(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }
}
