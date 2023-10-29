package edu.hw4;

import java.util.List;

public class Task13 {
    private Task13() {
    }

    public static List<Animal> getAnimalsWithNamesContainingMoreThanTwoWords(List<Animal> animals) {
        return animals.stream().filter(x -> x.name().split(" ").length > 2).toList();
    }
}
