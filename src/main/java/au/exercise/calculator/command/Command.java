package au.exercise.calculator.command;

/**
 * Interface for Command
 */
public abstract class Command {

    protected Double operandA;
    protected Double operandB;

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

    public Double calculate(Double operandA, Double operandB) {
        return null;
    }
}
