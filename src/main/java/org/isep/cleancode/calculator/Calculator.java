package org.isep.cleancode.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public double evaluateMathExpression(String expression) {
        // \\s+ -> reg ex to match any whitespace
        List<String> expressionArray = expressionToArray(expression.replaceAll("\\s+", ""));

        for (int i = 0; i < expressionArray.size(); i++) {
            if (expressionArray.get(i).equals("*")) {
                double leftDigit = Double.parseDouble((expressionArray.get(i-1)));
                double rightDigit = Double.parseDouble((expressionArray.get(i+1)));
                double result = leftDigit * rightDigit;

                expressionArray.set(i-1, Double.toString(result));
                expressionArray.subList(i, i + 2).clear();

                i--;
            }
        }

        double res = Double.parseDouble(expressionArray.getFirst());
        for (int i = 1; i < expressionArray.size(); i+=2) {
            String operator = expressionArray.get(i);
            double nextNumber = Double.parseDouble(expressionArray.get(i + 1));

            if (operator.equals("+")) {
                res += nextNumber;
            } else if (operator.equals("-")) {
                res -= nextNumber;
            }
        }

        return res;
    }

    /*
    private double calculate(String expression, String operator) {
        // This method contains all the calculation logic
        String[] stringSplit = expression.split(operator);

        double res = Double.parseDouble(stringSplit[0]);

        for (int i = 1; i < stringSplit.length; i++) {
            double num = Double.parseDouble(stringSplit[i]);

            switch (operator) {
                case "\\+" -> res += num;
                case "\\-" -> res -= num;
                case "\\*" -> res *= num;
            }
        }

        return res;
    }
    */

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
