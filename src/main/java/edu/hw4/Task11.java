package edu.hw4;

import java.util.List;

public class Task11 {
    private final static int MIN_HEIGHT_BIG_ANIMALS = 100;

    private Task11() {
    }

    public static List<Animal> getListOfBigAnimalsWithBites(List<Animal> animals) {
        return animals.stream().filter(x -> x.bites() && x.height() > MIN_HEIGHT_BIG_ANIMALS).toList();
    }
}
