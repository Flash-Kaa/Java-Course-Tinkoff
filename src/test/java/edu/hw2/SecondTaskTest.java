package edu.hw2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SecondTaskTest {
    private SecondTaskTest() {
    }

    @Test
    void testSettersInRectAndSquare() {
        var task = new Task2();

        var rect = task.new Rectangle();
        var square = task.new Square();

        rect.setWidth(20);
        rect.setHeight(10);
        assertThat(rect.area()).isEqualTo(200.0);

        assertThatThrownBy(() -> square.setHeight(10))
            .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> square.setWidth(20))
            .isExactlyInstanceOf(IllegalArgumentException.class);

        square.setSide(20);
        assertThat(square.area()).isEqualTo(20 * 20);
    }
}
