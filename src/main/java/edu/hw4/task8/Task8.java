package edu.hw4.task8;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public class Task8 {
    private Task8() {
    }

    public static Animal getHeaviestAnimalAmongAnimalsBelowK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight))
            .get();
    }
}
