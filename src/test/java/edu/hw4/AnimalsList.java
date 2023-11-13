package edu.hw4;

import java.util.Arrays;
import java.util.List;

public class AnimalsList {
    private AnimalsList() {
    }

    public static List<Animal> getFirstList() {
        return Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 5, 1, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 3, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 2, false),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, false)
        );
    }

    public static List<Animal> getSecondList() {
        return Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 12, 15, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 4, 11, 18, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 5, 20, 25, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 18, 22, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 5, 1, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 6, 2, false),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 2, 4, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 2, 1, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 3, false),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 4, 11, 31, false)
        );
    }

    public static List<Animal> getThirdList() {
        return Arrays.asList(
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 3, 15, 10, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 2, 14, 9, false),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 5, 1, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 6, 12, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 5, 1, true),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 2, 6, 12, true),
            new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.M, 5, 5, 2, false),
            new Animal("Bird4", Animal.Type.BIRD, Animal.Sex.F, 4, 4, 18, false)
        );
    }

    public static List<Animal> getFourthList() {
        return Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 15, 200, 250, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 14, 190, 240, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 3, 2, 8, true),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 2, 1, 7, true),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 45, 9, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 1, 5, 1, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 4, true),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 2, 5, true),
            new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.M, 5, 4, 15, false),
            new Animal("Bird4", Animal.Type.BIRD, Animal.Sex.F, 4, 35, 14, false)
        );
    }

    public static List<Animal> getFifthList() {
        return Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 10, 400, 600, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 9, 380, 580, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 4, 4, 2, true),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 3, 38, 9, true),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 2, 1, 2, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 2, 11, 22, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 6, 12, 12, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 7, 14, 8, true),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 12, true),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 2, 65, 13, true),
            new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.M, 3, 5, 3, false),
            new Animal("Bird4", Animal.Type.BIRD, Animal.Sex.F, 2, 4, 25, false)
        );
    }

    public static List<Animal> getSixthList() {
        return Arrays.asList(
            new Animal("Cat one one", Animal.Type.CAT, Animal.Sex.M, 10, 400, 600, true),
            new Animal("Cat two two", Animal.Type.CAT, Animal.Sex.F, 9, 380, 580, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 4, 4, 2, true),
            new Animal("Bird two", Animal.Type.BIRD, Animal.Sex.F, 3, 38, 9, true),
            new Animal("Fish one", Animal.Type.FISH, Animal.Sex.M, 2, 1, 2, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 2, 11, 22, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 6, 12, 12, true),
            new Animal("Dog two", Animal.Type.DOG, Animal.Sex.F, 7, 14, 8, true),
            new Animal("Spider one one", Animal.Type.SPIDER, Animal.Sex.M, 2, 6, 12, true),
            new Animal("Spider two", Animal.Type.SPIDER, Animal.Sex.F, 2, 65, 13, true),
            new Animal("Bird4", Animal.Type.BIRD, Animal.Sex.M, 3, 5, 3, false),
            new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.F, 2, 4, 25, false)
        );
    }

    public static List<Animal> getListWithErrors() {
        return Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 10, 400, 600, true),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 9, -100, 580, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 4, 4, 12, true),
            new Animal("Bird2", null, null, -3, -18, -9, true),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 2, 0, 2, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 2, 11, 22, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 6, 12, 12, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 0, 14, 8, true),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, -2, 6, 0, true),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 2, 65, 13, true),
            new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.M, 3, 5, 3, false),
            new Animal("Bird4", Animal.Type.BIRD, Animal.Sex.F, 2, 4, 25, false)
        );
    }
}
