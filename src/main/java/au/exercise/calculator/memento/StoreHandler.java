package au.exercise.calculator.memento;

import au.exercise.calculator.exception.CalculatorException;

import java.util.Stack;

/**
 * Stack handler for Storage
 */
public class StoreHandler {

    private final Stack<Object> objectStack;

    public StoreHandler(){
        objectStack = new Stack<>();
    }

    public void addStack(Object object) throws CalculatorException {
        if (object != null) {
            objectStack.push(object);
        } else {
            throw new CalculatorException("Error while Storing value!", new NullPointerException());
        }
    }

    public Object getStack() {
        if (!this.objectStack.empty()) {
            objectStack.pop();
            return objectStack.size() == 0 ? null : objectStack.peek();
        }
        return null;
    }

    public void reset(){
        this.objectStack.clear();
    }
}