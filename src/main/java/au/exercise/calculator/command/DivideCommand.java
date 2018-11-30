package au.exercise.calculator.command;

/**
 * Divide Command
 */

public class DivideCommand extends Command {

    private Double operandA;
    private Double operandB;

    public DivideCommand() {
    }

    public DivideCommand(Double operandA, Double operandB) {
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
        return operandB / operandA;
    }

    public Double calculate(Double operandA, Double operandB) {
        return operandB / operandA;
    }
}
