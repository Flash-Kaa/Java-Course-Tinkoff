package edu.project2;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;
    private final Coordinate start;
    private final Coordinate end;

    public Maze(int height, int width, Coordinate start, Coordinate end, Cell[][] grid) {
        this.height = height;
        this.width = width;
        this.start = start;
        this.end = end;
        this.grid = grid;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public Cell getCell(Coordinate coordinate) {
        return grid[coordinate.x()][coordinate.y()];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }

    public Boolean coordinateInBounds(Coordinate coordinate) {
        return coordinate.x() > 0 && coordinate.x() < width
            && coordinate.y() > 0 && coordinate.y() < height;
    }
}
