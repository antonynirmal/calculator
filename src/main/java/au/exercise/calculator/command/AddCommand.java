package au.exercise.calculator.command;

/**
 * Add Command
 */

public class AddCommand extends Command {

    private Double operandA;
    private Double operandB;

    public AddCommand() {}

     public AddCommand(Double operandA, Double operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }

    public Double getOperandA() {
        return operandA;
    }

    public void setOperandA(Double operandA) {
        this.operandA = operandA;
    }

    public Double getOperandB() {
        return operandB;
    }

    public void setOperandB(Double operandB) {
        this.operandB = operandB;
    }

    public Double calculate() {
        return operandA + operandB;
    }

    public Double calculate(Double operandA, Double operandB) {
            return operandA + operandB;
    }
}
