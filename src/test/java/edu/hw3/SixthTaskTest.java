package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockExchange;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SixthTaskTest {
    private SixthTaskTest() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                new Stock[] {
                    new Stock("aaa", 30.11),
                    new Stock("bbb", 35.11),
                    new Stock("ccc", 43.10),
                    new Stock("ddd", 10.5),
                    new Stock("eee", 10.31)
                },
                new Stock("ccc", 43.10)
            ),
            Arguments.of(
                new Stock[] {
                    new Stock("aaa", 15d),
                    new Stock("bbb", 13.11),
                    new Stock("ccc", 11.1),
                    new Stock("ddd", 10.5),
                    new Stock("eee", 10.31)
                },
                new Stock("aaa", 15d)
            )
        );
    }

    static Stream<Arguments> argumentProviderWithRemove() {
        return Stream.of(
            Arguments.of(
                new Stock[] {
                    new Stock("aaa", 30.11),
                    new Stock("bbb", 35.11),
                    new Stock("ccc", 43.10),
                    new Stock("ddd", 10.5),
                    new Stock("eee", 10.31)
                },
                new Stock[] {
                    new Stock("aaa", 30.11),
                    new Stock("bbb", 35.11),
                    new Stock("ccc", 43.10),
                    new Stock("ddd", 10.5),
                    new Stock("eee", 10.31)
                },
                null
            ),
            Arguments.of(
                new Stock[] {
                    new Stock("aaa", 30.11),
                    new Stock("bbb", 35.11),
                    new Stock("ccc", 43.10),
                    new Stock("ddd", 10.5),
                    new Stock("eee", 10.31)
                },
                new Stock[] {
                    new Stock("aaa", 30.11),
                    new Stock("bbb", 35.11),
                    new Stock("ccc", 43.10),
                },
                new Stock("ddd", 10.5)
            ),
            Arguments.of(
                new Stock[] {
                },
                new Stock[] {
                    new Stock("aaa", 30.11),
                    new Stock("bbb", 35.11),
                    new Stock("ccc", 43.10),
                },
                null
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testStockAdd(Stock[] stockToAdd, Stock expected) {
        var stockExchange = new StockExchange();

        for (var i : stockToAdd) {
            stockExchange.add(i);
        }

        var actual = stockExchange.mostValuableStock();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argumentProviderWithRemove")
    void testStockAddAndRemove(Stock[] stockToAdd, Stock[] stockToRemove, Stock expected) {
        var stockExchange = new StockExchange();

        for (var i : stockToAdd) {
            stockExchange.add(i);
        }

        for (var i : stockToRemove) {
            stockExchange.remove(i);
        }

        var actual = stockExchange.mostValuableStock();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testAddNull() {
        var stockExchange = new StockExchange();

        assertThatThrownBy(() -> stockExchange.add(null))
            .isExactlyInstanceOf(NullPointerException.class);
    }
}
