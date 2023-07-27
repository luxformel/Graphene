/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author luxformel
 */
import java.awt.Point;
import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterperateFunction{

    public static void interperate(String inputFunction, int fromX, int toX) {
        //String inputFunction = "3 * sin(x) + ln(2) / cos(0.5)";
        for (double i = fromX; i <= toX; i++) {
            String instructions = parseMathOperations(inputFunction);
            System.out.println("Instructions:");
            System.out.println(instructions);

            Map<String, Double> variables = new HashMap<>();
            variables.put("x", (double) i); // Substitute value for 'x'

            double result = evaluateMathExpression(inputFunction, variables);
            System.out.println("Result: " + result);
            System.out.println("X: " + (int) i + "; Y: " + (int) result);
            Point point = new Point((int) i, (int) result);
            point = TranslateCoordinates.translateCoordinatesFromFunctionToPanel(point);
            Points.add(point);
            System.out.println("Translated: X: " + point.x + "; Y: " + point.y);
        }
    }

    public static String parseMathOperations(String input) {
        String[] operations = {"addition", "subtraction", "multiplication", "division", "sin", "cos", "tan", "ln", "power", "sqrt"};
        String patternString = "[-+*/(),^√]|sin|cos|tan|ln";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        StringBuilder instructions = new StringBuilder();
        int lastIndex = 0;

        while (matcher.find()) {
            int operatorIndex = matcher.start();
            String operation = matcher.group();

            for (int i = lastIndex; i < operatorIndex; i++) {
                instructions.append(input.charAt(i));
            }

            lastIndex = operatorIndex + operation.length();

            if (operation.matches("sin|cos|tan|ln")) {
                instructions.append(" - Perform the function " + operation + " with the next number or variable.\n");
            } else if (operation.equals("^")) {
                instructions.append(" - Perform " + operations[8] + " with the next number or variable as the exponent.\n");
            } else if (operation.equals("√")) {
                instructions.append(" - Perform " + operations[9] + " with the next number or variable.\n");
            } else {
                switch (operation) {
                    case "+":
                        instructions.append(" - Perform " + operations[0] + " with the next number or variable.\n");
                        break;
                    case "-":
                        instructions.append(" - Perform " + operations[1] + " with the next number or variable.\n");
                        break;
                    case "*":
                        instructions.append(" - Perform " + operations[2] + " with the next number or variable.\n");
                        break;
                    case "/":
                        instructions.append(" - Perform " + operations[3] + " with the next number or variable.\n");
                        break;
                    case "(":
                        instructions.append(" - Start a new sub-expression.\n");
                        break;
                    case ")":
                        instructions.append(" - End the current sub-expression.\n");
                        break;
                }
            }
        }

        for (int i = lastIndex; i < input.length(); i++) {
            instructions.append(input.charAt(i));
        }

        return instructions.toString();
    }

    public static double evaluateMathExpression(String expression, Map<String, Double> variables) {
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(Double.parseDouble(num.toString()));
            } else if (Character.isLetter(ch)) {
                StringBuilder functionName = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    functionName.append(expression.charAt(i));
                    i++;
                }
                i--;

                if (isFunction(functionName.toString())) {
                    operators.push(functionName.toString());
                } else {
                    double variableValue = variables.getOrDefault(functionName.toString(), 0.0);
                    operands.push(variableValue);
                }
            } else if (ch == '(') {
                operators.push("(");
            } else if (ch == ')') {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    performOperation(operands, operators);
                }
                if (!operators.isEmpty()) {
                    operators.pop(); // Pop '('
                }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '√') {
                while (!operators.isEmpty() && precedence(String.valueOf(ch)) <= precedence(operators.peek())) {
                    performOperation(operands, operators);
                }
                operators.push(String.valueOf(ch));
            }
        }

        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }

        return operands.pop();
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
            case "√":
                return 3;
            case "sin":
            case "cos":
            case "tan":
            case "ln":
                return 4;
        }
        return -1;
    }

    private static void performOperation(Stack<Double> operands, Stack<String> operators) {
        String operator = operators.pop();

        if (isFunction(operator)) {
            double operand = operands.pop();
            switch (operator) {
                case "sin":
                    operands.push(Math.sin(operand));
                    break;
                case "cos":
                    operands.push(Math.cos(operand));
                    break;
                case "tan":
                    operands.push(Math.tan(operand));
                    break;
                case "ln":
                    operands.push(Math.log(operand));
                    break;
                case "√":
                    operands.push(Math.sqrt(operand));
                    break;
            }
        } else if (operator.equals("^")) {
            double exponent = operands.pop();
            double base = operands.pop();
            operands.push(Math.pow(base, exponent));
        } else {
            double operand2 = operands.pop();
            double operand1 = operands.pop();

            switch (operator) {
                case "+":
                    operands.push(operand1 + operand2);
                    break;
                case "-":
                    operands.push(operand1 - operand2);
                    break;
                case "*":
                    operands.push(operand1 * operand2);
                    break;
                case "/":
                    operands.push(operand1 / operand2);
                    break;
            }
        }
    }

    private static boolean isFunction(String name) {
        return name.equals("sin") || name.equals("cos") || name.equals("tan") || name.equals("ln") || name.equals("√");
    }

}

