package edu.hw4;

import java.util.List;

public class Task12 {
    private Task12() {
    }

    public static Integer getCountAnimalsWithWeightExceedingHeight(List<Animal> animals) {
        return (int) animals.stream().filter(x -> x.weight() > x.height()).count();
    }
}
