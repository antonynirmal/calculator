package au.exercise.calculator.factory;

import au.exercise.calculator.Operator;
import au.exercise.calculator.command.*;

/**
 * Calculator Factory
 */
public class CalculatorFactory {

    public Command getCommand(String token){
        if(token == null){
            return null;
        }

        if(token.equals(Operator.SQUARE.getOperator())){
            return new SquareCommand();

        } else if(token.equals(Operator.UNDO.getOperator())){
            return new SquareCommand();

        } else if(token.equals(Operator.CLEAR.getOperator())){
            return new SquareCommand();
        }
        else if(token.equals(Operator.ADD.getOperator())){
            return new AddCommand();
        }
        else if(token.equals(Operator.SUBSTRACT.getOperator())){
            return new SubtractCommand();
        }
        else if(token.equals(Operator.MULTIPLE.getOperator())){
            return new MultiplyCommand();
        }
        else if(token.equals(Operator.DIVIDE.getOperator())){
            return new DivideCommand();
        }
        return null;
    }
}