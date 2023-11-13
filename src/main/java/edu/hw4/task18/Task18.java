package edu.hw4.task18;

import edu.hw4.Animal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task18 {
    private Task18() {
    }

    // Найти самую тяжелую рыбку в 2-х или более списках
    public static Animal getHeavestFish(List<Animal>... animalLists) {
        return Arrays.stream(animalLists)
            .map(
                x -> x.stream()
                    .filter(z -> z.type() == Animal.Type.FISH)
                    .max(Comparator.comparingInt(Animal::weight))
                    .get()
            )
            .max(Comparator.comparingInt(Animal::weight))
            .get();
    }
}
