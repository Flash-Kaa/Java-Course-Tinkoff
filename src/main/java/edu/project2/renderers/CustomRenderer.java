package edu.project2.renderers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.List;

public class CustomRenderer implements Render {
    @Override
    public String render(Maze maze) {
        return render(maze, null);
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        var sb = new StringBuilder();
        sb.append("\n");

        for (var y = 0; y < maze.getHeight(); y++) {
            for (var x = 0; x < maze.getWidth(); x++) {
                sb.append(getCellSymbol(maze, new Coordinate(x, y), path));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String getCellSymbol(Maze maze, Coordinate coordinate, List<Coordinate> path) {
        if (path != null && path.contains(coordinate)) {
            return "**";
        } else if (maze.getCell(coordinate.x(), coordinate.y()) == Cell.WALL) {
            return "██";
        }

        return "  ";
    }
}
