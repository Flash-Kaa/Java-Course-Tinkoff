package edu.hw4;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class EighteenthTaskTest {
    private EighteenthTaskTest() {
    }

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 6, 12, false),
                AnimalsList.getFirstList(), AnimalsList.getSecondList(), AnimalsList.getThirdList()
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testGetHeavestFish(Animal expected, List<Animal> input1, List<Animal> input2, List<Animal> input3) {
        var actual = Task18.getHeavestFish(input1, input2, input3);
        assertThat(actual).isEqualTo(expected);
    }
}
