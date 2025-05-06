package org.isep.cleancode.calculator;

import java.util.Arrays;

public class Calculator {
    public double evaluateMathExpression(String expression) {
        // \\s+ -> reg ex to match any whitespace
        String noSpacesExpression = expression.replaceAll("\\s+", "");

        if (noSpacesExpression.contains("+")) {
            return calculate(noSpacesExpression, "\\+");
        } else if (noSpacesExpression.contains("-")) {
            return calculate(noSpacesExpression, "\\-");
        } else if (noSpacesExpression.contains("*")) {
            return calculate(noSpacesExpression, "\\*");
        } else {
            return Double.parseDouble(noSpacesExpression);
        }
    }

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
}
