package edu.hw2.connections;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
    }

    public ConnectionException(String message, Exception exception) {
        super(message, exception);
    }
}
