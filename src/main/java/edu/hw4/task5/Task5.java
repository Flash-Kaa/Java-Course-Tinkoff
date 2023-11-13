package edu.hw4.task5;

import edu.hw4.Animal;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    // Каких животных больше: самцов или самок
    public static Animal.Sex getSexOfMostAnimals(List<Animal> animals) {
        long countSexM = animals.stream()
            .filter(x -> x.sex() == Animal.Sex.M)
            .count();

        long countSexF = animals.stream()
            .filter(x -> x.sex() == Animal.Sex.F)
            .count();

        return countSexM >= countSexF ? Animal.Sex.M : Animal.Sex.F;
    }
}
