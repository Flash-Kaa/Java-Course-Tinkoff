package edu.hw2.expressions;

public record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }
}
