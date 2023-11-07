package edu.hw4.task2;

import edu.hw4.Animal;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<Animal> sortByWeightAndTakeKFirst(List<Animal> animals, int takeK) {
        return animals
            .stream()
            .sorted((a, b) -> Integer.compare(b.weight(), a.weight()))
            .limit(takeK)
            .toList();
    }
}
