package edu.hw4.task14;

import edu.hw4.Animal;
import java.util.List;

public class Task14 {
    private Task14() {
    }

    // Есть ли в списке собака ростом более k см
    public static Boolean haveDogWithHeightMoreK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(
                x -> x.type().equals(Animal.Type.DOG) && x.height() > k
            );
    }
}
