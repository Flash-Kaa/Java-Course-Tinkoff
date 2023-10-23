package edu.hw2;

import edu.hw2.connections.DefaultConnectionManager;
import edu.hw2.connections.FaultyConnection;
import edu.hw2.connections.FaultyConnectionManager;
import edu.hw2.connections.PopularCommandExecutor;
import edu.hw2.connections.StableConnection;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThirdTaskTest {
    private ThirdTaskTest() {
    }

    @Test
    void testCanGetStableAndFaultyConnection() {
        var manager = new DefaultConnectionManager();
        var haveFaultyConnection = false;
        var haveStableConnection = false;

        for(var i = 0; i < 100; i++) {
            var connection = manager.getConnection();

            if(connection instanceof FaultyConnection) {
                haveFaultyConnection = true;
            } else if(connection instanceof StableConnection) {
                haveStableConnection = true;
            }
        }

        assertThat(haveFaultyConnection).isTrue();
        assertThat(haveStableConnection).isTrue();
    }

    @Test
    void testCanThrowConnectException() {
        var haveException = false;

        for(var i = 0; i < 100; i++) {
            try (var faultyConnection = new FaultyConnection()) {
                faultyConnection.execute("");
            } catch (Exception e) {
                haveException = true;
            }

            if(haveException) {
                break;
            }
        }

        assertThat(haveException).isTrue();
    }

    @Test
    void testExecutorCanThrowException() {
        var haveException = false;
        var connectionManager = new FaultyConnectionManager();

        for(var i = 0; i < 100; i++) {
            try {
                var executor = new PopularCommandExecutor(connectionManager, 1);
                executor.updatePackages();
            } catch (Exception e) {
                haveException = true;
            }

            if(haveException) {
                break;
            }
        }

        assertThat(haveException).isTrue();
    }
}
