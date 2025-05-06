package org.isep.cleancode.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public double evaluateMathExpression(String expression) {
        // \\s+ -> reg ex to match any whitespace
        List<String> expressionArray = expressionToArray(expression.replaceAll("\\s+", ""));
        return evaluateSum(evaluateMultiplication(expressionArray));
    }

    private List<String> evaluateMultiplication(List<String> expression) {
        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i).equals("*")) {
                double leftDigit = Double.parseDouble((expression.get(i-1)));
                double rightDigit = Double.parseDouble((expression.get(i+1)));
                double result = leftDigit * rightDigit;

                expression.set(i-1, Double.toString(result));
                expression.subList(i, i + 2).clear();

                i--;
            }
        }

        return expression;
    }

    private Double evaluateSum(List<String> expression){
        double res = Double.parseDouble(expression.getFirst());
        for (int i = 1; i < expression.size(); i+=2) {
            String operator = expression.get(i);
            double nextNumber = Double.parseDouble(expression.get(i + 1));

            if (operator.equals("+")) {
                res += nextNumber;
            } else if (operator.equals("-")) {
                res -= nextNumber;
            }
        }

        return res;
    }

    private List<String> expressionToArray(String expression) {
        List<String> stringList = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char character : expression.toCharArray() ) {
            if (Character.isDigit(character) || character == '.') {
                number.append(character);
            } else {
                if (!number.isEmpty()) {
                    stringList.add(number.toString());
                    number.setLength(0);
                }
                stringList.add(String.valueOf(character));
            }
        }
        if (!number.isEmpty()) {
            stringList.add(number.toString());
        }

        return stringList;
    }
}
