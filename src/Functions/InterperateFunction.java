/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

/**
 *
 * @author luxformel
 */

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterperateFunction{
    
    
    
    
    
    /*
    public static Point[] interperate(String inputFunction, int fromX, int toX) {
        //String inputFunction = "3 * sin(x) + ln(2) / cos(0.5)";
        int dimension = (Math.abs(fromX) + toX) * 10;
        Point[] points = new Point[dimension];
        int counter = 0;
        for (double i = fromX; i <= toX; i += 0.1) {
            
            String instructions = parseMathOperations(inputFunction);
            //System.out.println("Instructions:");
            //System.out.println(instructions);

            Map<String, Double> variables = new HashMap<>();
            variables.put("x", (double) i); // Substitute value for 'x'

            double result = evaluateMathExpression(inputFunction, variables);
            //System.out.println("Result: " + result);
            
            int x = (int) i;
            double y = (int) result;
            
            int startX = Math.abs(Axis.getStartX());
            int endY = Math.abs(Axis.getEndY());
            int distBetwLinesX = Axis.getDistanceBetweenLinesX();
            int distBetwLinesY = Axis.getDistanceBetweenLinesY();

            
            
            // translates the coordinates to draw on the drawPanel
            
            x = (int) ((i + startX) * distBetwLinesX);
            y = ((endY - result) * distBetwLinesY);
            
            // checks if y was calculated sucessfully
            
            if (!Double.isNaN(y)) {
                
                Point point = new Point(x,(int) y);
                points[counter] = point;
                 
                // if the point is on the grid it is added to grid Points
                
                if (x % distBetwLinesX == 0 || y % distBetwLinesY == 0) {
                    AxisPoints.add(point);
                }
               
            }
            counter++;
        }
        return points;
    }
    */
    
    public static double interperate(String function, double x) {
        String inputFunction = function;
        String instructions = parseMathOperations(inputFunction);
        System.out.println("Instructions:");
        System.out.println(instructions);

        Map<String, Double> variables = new HashMap<>();
        variables.put("x", x); // Substitute value for 'x'

        double result = evaluateMathExpression(inputFunction, variables);
        System.out.println("Result: " + result);
        
        return result;
    }

    public static String parseMathOperations(String input) {
        String[] operations = {"addition", "subtraction", "multiplication", "division", "sin", "cos", "tan", "ln", "power", "sqrt", "exp"};
        String patternString = "[-+*/(),^]|sin|cos|tan|ln|sqrt|exp";
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

            if (operation.matches("sin|cos|tan|ln|exp")) {
                instructions.append(" - Perform the function " + operation + " with the next number or variable.\n");
            } else if (operation.equals("^")) {
                instructions.append(" - Perform " + operations[8] + " with the next number or variable as the exponent.\n");
            } else if (operation.equals("sqrt")) {
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
                    String variableName = functionName.toString();
                    if (variables.containsKey(variableName)) {
                        operands.push(variables.get(variableName));
                    } else {
                        throw new IllegalArgumentException("Variable '" + variableName + "' is not defined.");
                    }
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
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '√' || ch == 'e') {
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
            case "e":
                return 3;
            case "sin":
            case "cos":
            case "tan":
            case "ln":
            case "exp":
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
                case "sqrt":
                    operands.push(Math.sqrt(operand));
                    break;
                case "exp":
                    operands.push(Math.exp(operand));
                    break;
            }
        } else if (operator.equals("^")) {
            double exponent = operands.pop();
            double base = operands.pop();
            operands.push(Math.pow(base, exponent));
        } else if (operator.equals("e")) {
            operands.push(Math.exp(1));
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
        return name.equals("sin") || name.equals("cos") || name.equals("tan") || name.equals("ln") || name.equals("sqrt") || name.equals("exp");
    }
}
