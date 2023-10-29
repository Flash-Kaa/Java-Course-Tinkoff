package edu.hw4;

import java.util.List;

public class Task15 {
    private Task15() {
    }

    public static Integer getTotalWeightBySpeciesInAgeRange(List<Animal> animals, int k, int l) {
        return animals.stream()
            .reduce(0, (acc, a) -> acc + (a.age() >= k && a.age() <= l ? a.weight() : 0), Integer::sum);
    }
}
