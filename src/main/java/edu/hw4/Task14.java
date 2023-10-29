package edu.hw4;

import java.util.List;

public class Task14 {
    private Task14() {
    }

    public static Boolean haveDogWithHeightMoreK(List<Animal> animals, int k) {
        return animals.stream().anyMatch(x -> x.type().equals(Animal.Type.DOG) && x.height() > k);
    }
}
