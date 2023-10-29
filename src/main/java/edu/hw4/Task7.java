package edu.hw4;

import java.util.List;

public class Task7 {
    private Task7() {
    }

    public static Animal getOldest(List<Animal> animals) {
        return animals.stream().max((a, b) -> ((Integer) a.age()).compareTo(b.age())).get();
    }
}
