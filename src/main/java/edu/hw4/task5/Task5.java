package edu.hw4.task5;

import edu.hw4.Animal;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    public static Animal.Sex getSexOfMostAnimals(List<Animal> animals) {
        int countSexM = 0;
        int countSexF = 0;

        for (Animal i : animals) {
            switch (i.sex()) {
                case M -> countSexM++;
                case F -> countSexF++;
                default -> throw new RuntimeException();
            }
        }

        return countSexM >= countSexF ? Animal.Sex.M : Animal.Sex.F;
    }
}
