package edu.project2;

import edu.project2.generators.GeneratorDFS;
import edu.project2.renderers.CustomRenderer;
import edu.project2.solvers.SolverBFS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int HEIGHT = 41;
    private static final int WIDTH = 41;

    private Main() {
    }

    public static void main(String[] args) {
        var maze = new GeneratorDFS().generate(HEIGHT, WIDTH);
        var renderer = new CustomRenderer();
        var path = new SolverBFS().solve(maze);

        LOGGER.info(renderer.render(maze));
        LOGGER.info(renderer.render(maze, path));
    }
}
