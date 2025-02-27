package edu.hw1;

public class Task8 {
    private Task8() {
    }

    private static final int BOARD_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        checkCorrectness(board);

        for (var y = 0; y < board.length; y++) {
            for (var x = 0; x < board[y].length; x++) {

                if (board[y][x] == 0) {
                    continue;
                } else if (board[y][x] != 1) {
                    throw new IllegalArgumentException();
                }

                if (itsKnight(x - 2, y + 1, board)
                    || itsKnight(x - 1, y + 2, board)
                    || itsKnight(x + 1, y + 2, board)
                    || itsKnight(x + 2, y + 1, board)
                ) {
                    return false;
                }

            }
        }

        return true;
    }

    private static void checkCorrectness(int[][] board) {
        if (board.length != BOARD_SIZE) {
            throw new IllegalArgumentException();
        }

        for (var line : board) {
            if (line.length != BOARD_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean itsKnight(int x, int y, int[][] board) {
        return y >= 0 && y < board.length
            && x >= 0 && x < board[y].length
            && board[y][x] == 1;
    }
}
