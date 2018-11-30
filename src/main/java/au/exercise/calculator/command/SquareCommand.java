package au.exercise.calculator.command;

/**
 * Square Command
 */

public class SquareCommand extends Command {
    private Double operandA;

    public SquareCommand(){}

    public SquareCommand(Double operandA) {
        this.operandA = operandA;
    }

    public Double getOperand() {
        return operandA;
    }

    public void setOperand(Double operandA) {
        this.operandA = operandA;
    }

    public Double calculate() {
        return Math.sqrt(operandA);
    }

    public Double calculate(Double operandA, Double operandB) {
        return Math.sqrt(operandA);
    }
}