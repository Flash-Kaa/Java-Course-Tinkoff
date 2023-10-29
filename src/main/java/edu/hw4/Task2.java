package edu.hw4;

import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<Animal> sortByWeightAndTakeKFirst(List<Animal> animals, int takeK) {
        return animals
            .stream()
            .sorted((a, b) -> ((Integer) b.weight()).compareTo(a.weight()))
            .limit(takeK)
            .toList();
    }
}
