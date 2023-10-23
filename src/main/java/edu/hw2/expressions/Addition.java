package edu.hw2.expressions;

public record Addition(Expr firstValue, Expr secondValue) implements Expr {
    @Override
    public double evaluate() {
        if (firstValue == null || secondValue == null) {
            throw new NullPointerException();
        }

        return firstValue.evaluate() + secondValue.evaluate();
    }
}
