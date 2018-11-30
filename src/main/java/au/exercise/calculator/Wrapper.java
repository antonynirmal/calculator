package au.exercise.calculator;

import au.exercise.calculator.exception.CalculatorException;
import au.exercise.calculator.memento.Store;
import au.exercise.calculator.memento.StoreHandler;

import java.util.Stack;

/**
 * Stack Wrapper Class for Stack operations
 */
public class Wrapper {

    private Stack<Double> stack;
    private StoreHandler storeHandler;

    public Wrapper() {
        stack = new Stack<>();
        storeHandler = new StoreHandler();
    }

    public Stack<Double> getStack() {
        return stack;
    }

    // Push to Stack and persist using memento
    public void push(Double input) throws CalculatorException {
        stack.push(input);
        storeHandler.addStack(store());
    }

    // Stack pop
    public Double pop() {
            return stack.pop();
    }

    //Clone and persist for undo
    public Store store() {
        return new Store((Stack) stack.clone());
    }

    // To retrieve persisted repo
    void retrieve(Store repo) {
        stack = repo.getStack();
    }

    // Undo method
    public void undo() {
        Store store = (Store) storeHandler.getStack();
        if (store != null)
            this.retrieve(store);
        else {
            stack.clear();
            System.out.println("Stack is empty!");
        }
    }

    // To reset stack
    public void clear(){
        stack.clear();
        storeHandler.reset();
    }
}