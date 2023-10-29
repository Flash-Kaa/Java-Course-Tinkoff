package edu.hw4;

import java.util.List;

public class Task10 {
    private Task10() {
    }

    public static List<Animal> getAnimalsWithMismatchedAgeAndPaws(List<Animal> animals) {
        return animals.stream().filter(x -> x.age() != x.paws()).toList();
    }
}


