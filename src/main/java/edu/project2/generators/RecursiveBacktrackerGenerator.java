package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RecursiveBacktrackerGenerator implements Generator {
    private final Random random;
    private final static int MIN_COORDINATE = -2;
    private final static int MAX_COORDINATE = 2;
    private Cell[][] maze;

    public RecursiveBacktrackerGenerator() {
        random = new Random();
    }

    @Override
    public Maze generate(int height, int width) {
        if (height % 2 == 0 || width % 2 == 0) {
            throw new IllegalArgumentException();
        }

        maze = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                maze[x][y] = Cell.WALL;
            }
        }

        generateFrom(new Coordinate(1, 1), height, width);

        var start = new Coordinate(0, 1);
        var end = new Coordinate(width - 1, height - 2);

        maze[start.x()][start.y()] = Cell.NONE;
        maze[end.x()][end.y()] = Cell.NONE;
        return new Maze(height, width, start, end, maze);
    }

    private void generateFrom(Coordinate coord, int height, int width) {
        var directions = new ArrayList<>(getDirections());
        shuffleArray(directions);

        for (var direction : directions) {
            var next = coord.plus(direction);

            if (next.x() > 0 && next.x() < width - 1 && next.y() > 0 && next.y() < height - 1
                && maze[next.x()][next.y()] == Cell.WALL) {
                maze[next.x()][next.y()] = Cell.NONE;
                maze[coord.x() + direction.x() / 2][coord.y() + direction.y() / 2] = Cell.NONE;
                generateFrom(next, height, width);
            }
        }
    }

    private void shuffleArray(ArrayList arr) {
        for (int firstIndex = arr.size() - 1; firstIndex > 0; firstIndex--) {
            var secondIndex = random.nextInt(firstIndex + 1);

            var temp = arr.get(firstIndex);
            arr.set(firstIndex, arr.get(secondIndex));
            arr.set(secondIndex, temp);
        }
    }

    private List<Coordinate> getDirections() {
        return List.of(
            new Coordinate(MAX_COORDINATE, 0),
            new Coordinate(MIN_COORDINATE, 0),
            new Coordinate(0, MAX_COORDINATE),
            new Coordinate(0, MIN_COORDINATE)
        );
    }
}
