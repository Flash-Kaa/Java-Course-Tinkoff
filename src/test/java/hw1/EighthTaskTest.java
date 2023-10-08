package hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EighthTaskTest {
    private EighthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                "0, 0, 0, 1, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 1, 0, 0, 0, 1, 0, 0;" +
                    "0, 0, 0, 0, 1, 0, 1, 0;" +
                    "0, 1, 0, 0, 0, 1, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 1, 0, 0, 0, 0, 0, 1;" +
                    "0, 0, 0, 0, 1, 0, 0, 0",
                true
            ),
            Arguments.of(
                "1, 0, 1, 0, 1, 0, 1, 0;" +
                    "0, 1, 0, 1, 0, 1, 0, 1;" +
                    "0, 0, 0, 0, 1, 0, 1, 0;" +
                    "0, 0, 1, 0, 0, 1, 0, 1;" +
                    "1, 0, 0, 0, 1, 0, 1, 0;" +
                    "0, 0, 0, 0, 0, 1, 0, 1;" +
                    "1, 0, 0, 0, 1, 0, 1, 0;" +
                    "0, 0, 0, 1, 0, 1, 0, 1",
                false
            ),
            Arguments.of(
                "0, 0, 0, 0, 1, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 1, 0, 0;" +
                    "0, 0, 0, 1, 0, 0, 0, 0;" +
                    "1, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 1, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 1, 0, 0;" +
                    "0, 0, 0, 0, 0, 1, 0, 0;" +
                    "1, 0, 0, 0, 0, 0, 0, 0",
                false
            ),
            Arguments.of(
                "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0;" +
                    "0, 0, 0, 0, 0, 0, 0, 0",
                true
            ),
            Arguments.of(
                "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1;" +
                    "1, 1, 1, 1, 1, 1, 1, 1",
                false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    @DisplayName("Test any boards")
    void testKnightCapture(String strBoard, boolean expected) {
        var board = parseMatrix(strBoard);
        var res = Task8.knightBoardCapture(board);

        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Have illegal argument on board")
    void testDeskWithIllegalArgumentOnBoard() {
        var strBoard = "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 3, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0";

        var board = parseMatrix(strBoard);

        assertThatThrownBy(() -> Task8.knightBoardCapture(board)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Have illegal board size")
    void testDeskWithIllegalBoardSize_1() {
        //4x8
        var strBoard = "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0;";

        var board = parseMatrix(strBoard);

        assertThatThrownBy(() -> Task8.knightBoardCapture(board)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Have illegal board size")
    void testDeskWithIllegalBoardSize_2() {
        // 8x12
        var strBoard = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0;" +
            "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";

        var board = parseMatrix(strBoard);

        assertThatThrownBy(() -> Task8.knightBoardCapture(board)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    private int[][] parseMatrix(String matrixString) {
        String[] rows = matrixString.split(";");
        int numRows = rows.length;
        int numCols = rows[0].split(", ").length;
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] rowValues = rows[i].split(", ");
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = Integer.parseInt(rowValues[j].trim());
            }
        }

        return matrix;
    }
}
