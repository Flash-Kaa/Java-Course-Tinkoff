package edu.hw2.expressions;

public record Exponent(Expr firstValue, int degree) implements Expr {
    @Override
    public double evaluate() {
        if (firstValue == null) {
            throw new NullPointerException();
        }

        return Math.pow(firstValue.evaluate(), degree);
    }
}
