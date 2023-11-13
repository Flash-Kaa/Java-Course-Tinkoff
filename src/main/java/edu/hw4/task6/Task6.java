package edu.hw4.task6;

import edu.hw4.Animal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Task6 {
    private Task6() {
    }

    // Самое тяжелое животное каждого вида
    public static Map<Animal.Type, Animal> getAnimalEachTypeWithMaxWidth(List<Animal> animals) {
        return animals.stream()
            .collect(
                Collectors.toMap(
                    Animal::type,
                    animal -> animal,
                    BinaryOperator.maxBy(Comparator.comparingDouble(Animal::weight))
                )
            );
    }
}
