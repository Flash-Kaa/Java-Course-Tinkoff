package edu.hw2.connections;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
