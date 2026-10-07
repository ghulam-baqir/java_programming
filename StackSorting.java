import java.util.Stack;

public class StackSorting {

    public static void sortStack(Stack<Integer> stack) {

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {

            int current = stack.pop();

            while (!temp.isEmpty() && temp.peek() > current) {
                stack.push(temp.pop());
            }

            temp.push(current);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Before sorting: " + stack);

        sortStack(stack);

        System.out.println("After sorting: " + stack);
    }
}