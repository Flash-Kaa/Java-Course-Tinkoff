package edu.hw4;

import java.util.List;

public class Task9 {
    private Task9() {
    }

    public static Integer getSumPaws(List<Animal> animals) {
        return animals.stream()
            .reduce(0, (acc, a) -> acc + a.paws(), Integer::sum);
    }
}
