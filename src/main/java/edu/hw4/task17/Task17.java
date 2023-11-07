package edu.hw4.task17;

import edu.hw4.Animal;
import java.util.List;

public class Task17 {
    private Task17() {
    }

    public static Boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        return animals
            .stream()
            .filter(Animal::bites)
            .reduce(0, (acc, a) ->
                    a.type() == Animal.Type.SPIDER ? acc + 1 : (a.type() == Animal.Type.DOG ? acc - 1 : 0),
                Integer::sum
            ) > 0;
    }
}
