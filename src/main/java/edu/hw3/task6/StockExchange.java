package edu.hw3.task6;

import java.util.PriorityQueue;

public class StockExchange implements StockMarket {
    private final PriorityQueue<Stock> stockList;

    public StockExchange() {
        stockList = new PriorityQueue<>((a, b) -> b.price().compareTo(a.price()));
    }

    @Override
    public void add(Stock stock) {
        if (stock == null) {
            throw new NullPointerException();
        }

        stockList.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockList.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockList.peek();
    }
}
