package au.exercise.calculator;

import au.exercise.calculator.exception.CalculatorException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Cases
 */
public class CalculatorTest {

    @Test
    public void AddToStack() throws CalculatorException {
        Calculator tester = new Calculator();

        tester.calculate("5 2");
        String out = "";
            for (Double E : tester.getWrapper().getStack())
                out = out + E +" ";

        // assert statements
        assertEquals("5.0 2.0".trim(), out.trim());
        tester.output();
    }

    @Test
    public void AdditionOfTwoNumbers()  throws CalculatorException {
        Calculator tester = new Calculator();

       tester.calculate("1 1 +");
       double result = tester.getWrapper().getStack().peek();
        // assert statements
        assertEquals(0, result, 2.0);
        tester.output();

    }

    @Test
    public void AdditionOfThreeNumbersAndUndo()  throws CalculatorException {
        Calculator tester = new Calculator();

        tester.calculate("1 2 3 + + undo");
        String out = "";
        for (Double E : tester.getWrapper().getStack())
            out = out + E +" ";
        double d = tester.getWrapper().getStack().peek();
        // assert statements
        assertEquals("1.0 5.0".trim(), out.trim());
        tester.output();

    }

    @Test
    public void SquareRootOfTwo() throws CalculatorException {
        Calculator tester = new Calculator();

        tester.calculate("2 sqrt");
        double result = tester.getWrapper().getStack().peek();
        // assert statements
        assertEquals(0, result, 1.4142135623730951);
        tester.output();

    }

    @Test
    public void InsufficientParameter() throws CalculatorException {
        Calculator tester = new Calculator();

        tester.calculate("1 2 3 * 5 + * * 6 5");
        double result = tester.getWrapper().getStack().peek();
        // assert statements
        assertEquals(11.0, result, 0.0);
        tester.output();

    }

    @Test
    public void DividebyZero() throws CalculatorException {
        Calculator tester = new Calculator();

        tester.calculate("1 0");
        // assert statements
        assertEquals("Undefined - Divide by 0", "Undefined - Divide by 0");
        tester.output();
    }

    @Test
    public void SubtractAndClear() throws CalculatorException {
        Calculator tester = new Calculator();

        tester.calculate("5 2 clear");
        boolean result = tester.getWrapper().getStack().empty();
        // assert statements
        assertEquals("Stack is Empty: ",true, result);
    }

}