package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class GeneratorDFS implements Generator {
    private final Random random = new Random();
    private Cell[][] maze;

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

        var stack = new Stack<Coordinate>();
        var start = new Coordinate(1, 1);
        maze[start.x()][start.y()] = Cell.NONE;
        stack.push(start);

        while (!stack.isEmpty()) {
            var currentCell = stack.peek();

            var neighbors = getUnvisitedNeighbors(currentCell, height, width);
            if (!neighbors.isEmpty()) {
                var next = neighbors.get(random.nextInt(neighbors.size()));
                maze[next.x()][next.y()] = Cell.NONE;
                maze[currentCell.x() + (next.x() - currentCell.x()) / 2][currentCell.y()
                    + (next.y() - currentCell.y()) / 2] = Cell.NONE;
                stack.push(next);
            } else {
                stack.pop();
            }
        }
        maze[0][1] = Cell.NONE;
        maze[width - 1][height - 2] = Cell.NONE;

        return new Maze(height, width, new Coordinate(0, 1), new Coordinate(width - 1, height - 2), maze);
    }

    private ArrayList<Coordinate> getUnvisitedNeighbors(Coordinate coordinate, int height, int width) {
        var neighbors = new ArrayList<Coordinate>();

        if (coordinate.x() >= 2 && maze[coordinate.x() - 2][coordinate.y()] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x() - 2, coordinate.y()));
        }
        if (coordinate.x() < width - 2 && maze[coordinate.x() + 2][coordinate.y()] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x() + 2, coordinate.y()));
        }
        if (coordinate.y() >= 2 && maze[coordinate.x()][coordinate.y() - 2] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x(), coordinate.y() - 2));
        }
        if (coordinate.y() < height - 2 && maze[coordinate.x()][coordinate.y() + 2] == Cell.WALL) {
            neighbors.add(new Coordinate(coordinate.x(), coordinate.y() + 2));
        }

        return neighbors;
    }
}
