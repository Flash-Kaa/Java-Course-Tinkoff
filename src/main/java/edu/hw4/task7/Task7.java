package edu.hw4.task7;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;

public class Task7 {
    private Task7() {
    }

    public static Animal getOldest(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt(Animal::age)).get();
    }
}
