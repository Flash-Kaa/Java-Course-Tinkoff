package edu.hw2.connections;

import java.util.Random;

public class FaultyConnection implements Connection {
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int THROW_EXCEPTION_IF_RANDOM_NUMBER_MORE = 6;
    private static final Random RANDOM = new Random();

    @Override
    public void execute(String command) {
        if (RANDOM.nextInt(MAX_RANDOM_NUMBER + 1) > THROW_EXCEPTION_IF_RANDOM_NUMBER_MORE) {
            throw new ConnectionException();
        }

        // implement command execution
    }

    @Override
    public void close() throws Exception {
        // implement connection closure
    }
}
