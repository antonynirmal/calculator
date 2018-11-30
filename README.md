# Reverse Polish Notation Calculator

Calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators. Available operators are +, -, *, /, sqrt, undo, clear & exit.

- +, -, *, / : Performs arithmentic operations on the last 2 operands. 
- sqrt : sqrt performs a square root on the top item from the stack 
- clear: resets all the value from the stack undo: undoes the previous operation. 
- undo: will undo the previous two operations. exit: quit the application.

# Design Considerations
Following patterns are used in developing the solution.
- Command - To encapulate the operations performed by the calculator.
- Factory - Acts as a facade and creats required object without specifing the actual Class.
- Memento - Provides the ability to restore object to the previous state.

Reqirements Java 8, JUnit & Maven
Compile, Test & Run mvn compile mvn test mvn exec:run
