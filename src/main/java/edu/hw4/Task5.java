package edu.hw4;

import java.util.List;

public class Task5 {
    private Task5() {
    }

    public static Animal.Sex getSexOfMostAnimals(List<Animal> animals) {
        var countSexM = 0;
        var countSexF = 0;

        for (var i : animals) {
            switch (i.sex()) {
                case M -> countSexM++;
                case F -> countSexF++;
                default -> throw new RuntimeException();
            }
        }

        return countSexM >= countSexF ? Animal.Sex.M : Animal.Sex.F;
    }
}
