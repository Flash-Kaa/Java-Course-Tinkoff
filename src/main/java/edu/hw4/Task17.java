package edu.hw4;

import java.util.List;

public class Task17 {
    private Task17() {
    }

    public static Boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        return animals
            .stream()
            .reduce(0, (acc, a) -> {
                int valueForChange = acc;
                if (a.bites()) {
                    if (a.type() == Animal.Type.SPIDER) {
                        valueForChange++;
                    } else if (a.type() == Animal.Type.DOG) {
                        valueForChange--;
                    }
                }
                return valueForChange;
            }, Integer::sum) > 0;
    }
}
