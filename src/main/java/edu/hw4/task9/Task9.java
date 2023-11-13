package edu.hw4.task9;

import edu.hw4.Animal;
import java.util.List;

public class Task9 {
    private Task9() {
    }

    // Сколько в сумме лап у животных в списке
    public static Integer getSumPaws(List<Animal> animals) {
        return animals.stream()
            .reduce(0, (acc, a) -> acc + a.paws(), Integer::sum);
    }
}
