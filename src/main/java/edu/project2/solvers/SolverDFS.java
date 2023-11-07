package edu.project2.solvers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public final class SolverDFS implements Solver {
    private final static List<Coordinate> DIRECTIONS = List.of(
        new Coordinate(1, 0),
        new Coordinate(-1, 0),
        new Coordinate(0, 1),
        new Coordinate(0, -1)
    );

    @Override
    public List<Coordinate> solve(Maze maze) {
        var next = new Stack<Coordinate>() {{
            push(maze.getStart());
        }};
        var pathToPoint = new HashMap<Coordinate, ArrayList<Coordinate>>() {{
            put(maze.getStart(), new ArrayList<>(List.of(maze.getStart())));
        }};

        while (!next.isEmpty()) {
            Coordinate currentCoordinate = next.pop();

            for (Coordinate dir : DIRECTIONS) {
                Coordinate curNeighborCoordinate = currentCoordinate.plus(dir);

                if (maze.coordinateInBounds(curNeighborCoordinate) && maze.getCell(curNeighborCoordinate) == Cell.NONE
                    && !pathToPoint.containsKey(curNeighborCoordinate)) {
                    next.push(curNeighborCoordinate);

                    ArrayList<Coordinate> newList = (ArrayList<Coordinate>) pathToPoint.get(currentCoordinate).clone();
                    newList.add(curNeighborCoordinate);
                    pathToPoint.put(curNeighborCoordinate, newList);

                    if (curNeighborCoordinate.equals(maze.getEnd())) {
                        return newList;
                    }
                }
            }
        }
        return List.of();
    }
}
