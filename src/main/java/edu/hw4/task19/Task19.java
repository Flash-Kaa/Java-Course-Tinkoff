package edu.hw4.task19;

import edu.hw4.Animal;
import edu.hw4.ValidationError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 {
    private Task19() {
    }

    public static Map<String, Set<ValidationError>> getNamesAnimalsWithExceptions(List<Animal> animals) {
        var result = new HashMap<String, Set<ValidationError>>();

        for (var animal : animals) {
            var errors = new HashSet<ValidationError>();
            if (animal.age() < 0) {
                errors.add(new ValidationError("age can't be less then zero"));
            }

            if (animal.height() <= 0) {
                errors.add(new ValidationError("height can't be less or equal zero"));
            }

            if (animal.weight() <= 0) {
                errors.add(new ValidationError("weight can't be less or equal zero"));
            }

            if (animal.sex() == null) {
                errors.add(new ValidationError("sex can't be null"));
            }

            if (animal.type() == null) {
                errors.add(new ValidationError("type can't be null"));
            }

            if (!errors.isEmpty()) {
                result.put(animal.name(), errors);
            }
        }

        return result;
    }
}
