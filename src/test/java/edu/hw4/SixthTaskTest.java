package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SixthTaskTest {
    private SixthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFourthList(),
                new HashMap<Animal.Type, Animal>() {{
                    put(
                        Animal.Type.CAT,
                        new Animal(
                            "Cat1", Animal.Type.CAT, Animal.Sex.M, 15, 200, 250, true
                        )
                    );
                    put(
                        Animal.Type.BIRD,
                        new Animal(
                            "Bird3", Animal.Type.BIRD, Animal.Sex.M, 5, 4, 15, false
                        )
                    );
                    put(
                        Animal.Type.FISH,
                        new Animal(
                            "Fish1", Animal.Type.FISH, Animal.Sex.M, 1, 45, 9, false
                        )
                    );
                    put(
                        Animal.Type.SPIDER,
                        new Animal(
                            "Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 2, 5, true
                        )
                    );
                }}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetAnimalEachTypeWithMaxWidth(List<Animal> input, Map<Animal.Type, Animal> expected) {
        var actual = Task6.getAnimalEachTypeWithMaxWidth(input);
        assertThat(actual).isEqualTo(expected);
    }
}
