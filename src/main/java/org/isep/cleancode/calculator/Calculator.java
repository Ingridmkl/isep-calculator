package org.isep.cleancode.calculator;

import java.util.Arrays;

public class Calculator {
    public double evaluateMathExpression(String expression) {
        //  basicPositiveInteger and basicFloatingPointNumber
        // return Double.parseDouble(expression);

        /* basicAddition
        // \s+ -> reg ex to match any whitespace
        String noSpacesExpression = expression.replaceAll("\\s+", "");

        if (noSpacesExpression.contains("+")) {
            // Split string by +
            String[] stringSplit = noSpacesExpression.split("\\+");

            double num1 = Double.parseDouble(stringSplit[0]);
            double num2 = Double.parseDouble(stringSplit[1]);

            return num1 + num2;
        } else {
            return Double.parseDouble(noSpacesExpression);
        }
         */

        /* multiple additions

        // \s+ -> reg ex to match any whitespace
        String noSpacesExpression = expression.replaceAll("\\s+", "");

        if (noSpacesExpression.contains("+")) {
            // Split string by +
            String[] stringSplit = noSpacesExpression.split("\\+");

            double sum = 0;

            for (String num : stringSplit) {
                sum += Double.parseDouble(num);
            }

            return sum;
        } else {
            return Double.parseDouble(noSpacesExpression);
        }
         */

        /* subtractions

        // \s+ -> reg ex to match any whitespace
        String noSpacesExpression = expression.replaceAll("\\s+", "");

        if (noSpacesExpression.contains("+")) {
            // Split string by '+'
            String[] stringSplit = noSpacesExpression.split("\\+");

            double sum = 0;

            for (String num : stringSplit) {
                sum += Double.parseDouble(num);
            }

            return sum;
        } else if (noSpacesExpression.contains("-")) {
            // Split string by '-'
            String[] stringSplit = noSpacesExpression.split("\\-");

            double sum = Double.parseDouble(stringSplit[0]);

            for (int i = 1; i < stringSplit.length; i++) {
                sum -= Double.parseDouble(stringSplit[i]);
            }

            return sum;
        } else {
            return Double.parseDouble(noSpacesExpression);
        }
         */

        // multiplications

        // \s+ -> reg ex to match any whitespace
        String noSpacesExpression = expression.replaceAll("\\s+", "");

        if (noSpacesExpression.contains("+")) {
            // Split string by '+'
            String[] stringSplit = noSpacesExpression.split("\\+");

            double sum = 0;

            for (String num : stringSplit) {
                sum += Double.parseDouble(num);
            }

            return sum;
        } else if (noSpacesExpression.contains("-")) {
            // Split string by '-'
            String[] stringSplit = noSpacesExpression.split("-");

            double sum = Double.parseDouble(stringSplit[0]);

            for (int i = 1; i < stringSplit.length; i++) {
                sum -= Double.parseDouble(stringSplit[i]);
            }

            return sum;
        } else if (noSpacesExpression.contains("*")) {
            // Split string by '*'
            String[] stringSplit = noSpacesExpression.split("\\*");

            double sum = Double.parseDouble(stringSplit[0]);

            for (int i = 1; i < stringSplit.length; i++) {
                sum *= Double.parseDouble(stringSplit[i]);
            }

            return sum;
        } else {
            return Double.parseDouble(noSpacesExpression);
        }
    }
}
