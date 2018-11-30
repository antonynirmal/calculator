package au.exercise.calculator;

import au.exercise.calculator.exception.CalculatorException;

import java.util.Scanner;

/**
 * Main class that invokes calculator
 */
public class Main {
    public static void main(String[] args) {
        String expression;
        Calculator calculator = new Calculator();
        System.out.println("Reverse Polish Notation Calculator: Acceptable values are Operand(0 - 9), Operator(+, -, *, /), sqrt, clear, undo");
        System.out.println("Enter value in <Operand> <Operand> <Operator> format");
        do {
            Scanner input = new Scanner(System.in);
            expression = input.nextLine();
            try {
                calculator.calculate(expression);
                calculator.output();
            } catch (CalculatorException e) {
                e.printStackTrace();
            }
        }while(!expression.equalsIgnoreCase("exit"));
    }
}
