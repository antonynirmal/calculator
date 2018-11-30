package au.exercise.calculator;

import au.exercise.calculator.command.*;
import au.exercise.calculator.exception.CalculatorException;
import au.exercise.calculator.factory.CalculatorFactory;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * RPN Calculator
 */
public class Calculator {

    private Wrapper wrapper;
    private int position;
    private CalculatorFactory calculatorFactory;

    Calculator() {
        position = 0;
        wrapper = new Wrapper();
        calculatorFactory = new CalculatorFactory();
    }

    protected Wrapper getWrapper() {
        return wrapper;
    }

    //Calculate Reverse Polish Notation
    protected void calculate(String expression) throws CalculatorException {

        Scanner input = new Scanner(expression);
        String token;
        Double result;
        Command command;

        while (input.hasNext()) {
            position++;
            token = input.next();
            //Add the operand to the stack
            if (isOperand(token)) {
                wrapper.push(decimalFormat(Double.valueOf(token)));
            }
            command = calculatorFactory.getCommand(token);
            //Square operation
            if(token.equals(Operator.SQUARE.getOperator())){
                result = command.calculate(wrapper.pop(), null);
                wrapper.push(decimalFormat(result));
            }
            //Undo Operation
            if(token.equals(Operator.UNDO.getOperator())){
                wrapper.undo();
            }
            //Clear Operation
            if(token.equals(Operator.CLEAR.getOperator())){
                reset();
            }
            // Switch for Add, Sub, Multiple & Divide
            if (wrapper.getStack().size() > 1 && this.isOperator(token)) {

                switch(Operator.forValue(token)){
                    case ADD:{
                        wrapper.push(decimalFormat(command.calculate(wrapper.pop(), wrapper.pop())));
                        break;}
                    case SUBSTRACT:
                        wrapper.push(decimalFormat(command.calculate(wrapper.pop(), wrapper.pop())));
                        break;
                    case MULTIPLE:
                        wrapper.push(decimalFormat(command.calculate(wrapper.pop(), wrapper.pop())));
                        break;
                    case DIVIDE:
                        if(wrapper.getStack().peek() != 0)
                            wrapper.push(decimalFormat(command.calculate(wrapper.pop(), wrapper.pop())));
                            else
                            System.out.println("Undefined - Divide by 0");
                        break;
                    default:
                        new CalculatorException("Undefined Operator or Operand!");
                }
            } else if (wrapper.getStack().size() <= 1 && this.isOperator(token)) {
                System.out.println("Token " + token + "(position: " + position + ") : insufficient parameters");
                break;
            }
        }
    }

    // To validate existence of Operator in string
    private boolean isOperator(String input) {
        return input.equals(Operator.ADD.getOperator()) || input.equals(Operator.SUBSTRACT.getOperator()) ||
                input.equals(Operator.MULTIPLE.getOperator()) || input.equals(Operator.DIVIDE.getOperator()) ;
    }

    // To validate existence of Operand in string
    private boolean isOperand(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    // Reset and clear wrapper
    private void reset(){
        position=0;
        wrapper.clear();
        System.out.println("Stack is empty!");
    }

    //enforcing 15 digit
    private Double decimalFormat(Double digit) {
        NumberFormat format = NumberFormat.getIntegerInstance();
        int STORE_MAX_DIGIT = 15;
        Double formatDigit;
        format.setMaximumFractionDigits(STORE_MAX_DIGIT);
        format.setMaximumIntegerDigits(STORE_MAX_DIGIT);
        formatDigit = Double.valueOf(format.format(digit));
        return formatDigit;
    }

    // Limiting decimal to 10 for display
    private Double outputFormat(Double digit) throws CalculatorException {
        int DISPLAY_MAX_DIGIT = 10;
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setMaximumFractionDigits(DISPLAY_MAX_DIGIT);
        if(digit - Double.valueOf(format.format(digit)) < 0.0000001){
            return Double.valueOf(format.format(digit));
        }
        return digit;
    }

    //Print the Stack with whitespace as delimiter.
    protected void output() {
        System.out.print(">> ");
            wrapper.getStack().forEach(e -> {
                try {
                    System.out.print(outputFormat(e) + "  ");
                } catch (CalculatorException exception) {
                    System.out.println("Error while printing the Stack!");
                }
            });
        System.out.print("\n");
    }
}