package utils;

import java.util.Stack;

public class StackSorter {
    public static Stack<Integer> sort(Stack<Integer> originalStack) {
        Stack<Integer> helperStack = new Stack<>();

        while (!originalStack.isEmpty()) {
            int currentElement = originalStack.pop();

            while (!helperStack.isEmpty() && helperStack.peek() > currentElement) {
                originalStack.push(helperStack.pop());
            }
            helperStack.push(currentElement);
        }
        return helperStack;
    }
}
