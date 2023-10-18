package edu.hw2.connections;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final int MAX_RANDOM_NUMBER = 5;
    private static final int CREATE_FAULTY_CONNECTION_IF_RANDOM_NUMBER_MORE = 2;
    private static final Random RANDOM = new Random();

    @Override
    public Connection getConnection() {
        if (RANDOM.nextInt(MAX_RANDOM_NUMBER + 1) > CREATE_FAULTY_CONNECTION_IF_RANDOM_NUMBER_MORE) {
            return new FaultyConnection();
        }

        return new StableConnection();
    }
}
