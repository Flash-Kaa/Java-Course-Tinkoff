package edu.hw4.task6;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> getAnimalEachTypeWithMaxWidth(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::type,
            animal -> animal,
            (a, b) -> a.weight() > b.weight() ? a : b
        ));
    }
}
