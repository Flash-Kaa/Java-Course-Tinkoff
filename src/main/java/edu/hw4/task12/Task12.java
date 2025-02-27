package edu.hw4.task12;

import edu.hw4.Animal;
import java.util.List;

public class Task12 {
    private Task12() {
    }

    // Сколько в списке животных, вес которых превышает рост
    public static Integer getCountAnimalsWithWeightExceedingHeight(List<Animal> animals) {
        return (int) animals.stream()
            .filter(x -> x.weight() > x.height())
            .count();
    }
}
