package edu.hw4;

import java.util.List;

public class Task8 {
    private Task8() {
    }

    public static Animal getHeaviestAnimalAmongAnimalsBelowK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k).max((a, b) -> ((Integer) a.weight()).compareTo(b.weight()))
            .get();
    }
}
