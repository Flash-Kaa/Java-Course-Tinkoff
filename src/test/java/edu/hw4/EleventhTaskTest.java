package edu.hw4;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class EleventhTaskTest {
    private EleventhTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                AnimalsList.getFourthList(),
                List.of(
                    new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 15, 200, 250, true),
                    new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 14, 190, 240, true)
                )
            ),
            Arguments.of(
                AnimalsList.getFirstList(),
                List.of()
            ),
            Arguments.of(
                AnimalsList.getSecondList(),
                List.of()
            ),
            Arguments.of(
                AnimalsList.getThirdList(),
                List.of()
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetListOfBigAnimalsWithBites(List<Animal> input, List<Animal> expected) {
        var actual = Task11.getListOfBigAnimalsWithBites(input);
        assertThat(actual).isEqualTo(expected);
    }
}
