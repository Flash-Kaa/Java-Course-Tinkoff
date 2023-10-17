package edu.hw2.expressions;

public record Negate(Expr value) implements Expr {
    @Override
    public double evaluate() {
        if(value == null) {
            throw new NullPointerException();
        }
        return -value.evaluate();
    }
}
