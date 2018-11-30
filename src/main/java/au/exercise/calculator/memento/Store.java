package au.exercise.calculator.memento;

import java.util.Stack;

/**
 * Stack to perform Undo operation
 */
public class Store {
    public Stack<Double> repoStack;

    public Store(Stack stack) {
        this.repoStack = stack;
    }

    public Stack getStack() {
        return this.repoStack;
    }
}