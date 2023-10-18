package edu.hw2.connections;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (var i = 1; i <= maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (Exception e) {
                if (i == maxAttempts) {
                    throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts", e);
                }
            }
        }
    }
}
