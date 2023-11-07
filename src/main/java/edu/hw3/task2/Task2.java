package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final char[] BRACKETS = new char[] {'(', ')'};

    private Task2() {
    }

    public static List<String> clusterize(String input) {
        List<String> list = new ArrayList<>();
        int openBracketsCount = 0;
        StringBuilder curBracketExpression = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            if (!isBracket(bracket)) {
                throw new IllegalArgumentException();
            }

            if (bracket == BRACKETS[0]) {
                openBracketsCount++;
            } else {
                openBracketsCount--;

                if (openBracketsCount < 0) {
                    throw new IllegalArgumentException();
                }
            }

            curBracketExpression.append(bracket);
            if (openBracketsCount == 0) {
                list.add(curBracketExpression.toString());
                curBracketExpression.setLength(0);
            }
        }

        if (openBracketsCount > 0) {
            throw new IllegalArgumentException();
        }

        return list;
    }

    private static boolean isBracket(char symbol) {
        for (char i : BRACKETS) {
            if (symbol == i) {
                return true;
            }
        }
        return false;
    }
}
