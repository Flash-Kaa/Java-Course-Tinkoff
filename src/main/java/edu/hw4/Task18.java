package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task18 {
    private Task18() {
    }

    public static Animal getHeavestFish(List<Animal>... animalLists) {
        Comparator<Animal> weightComparator =
            (Animal x, Animal y) -> ((Integer) x.weight()).compareTo(y.weight());

        return Arrays.stream(animalLists)
            .map(x -> x.stream()
                .filter(z -> z.type() == Animal.Type.FISH)
                .max(weightComparator)
                .get()
            )
            .max(weightComparator)
            .get();
    }
}
