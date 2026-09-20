import structures.ArrayStack;
import structures.LinkedStack;
import structures.MinStack;
import utils.PalindromeChecker;
import utils.BalancedParentheses;
import utils.StackSorter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SUKKUR IBA UNIVERSITY - LAB 6 STACK ===");

        // Task 1 Test: ArrayStack
        System.out.println("\n--- Task 1: ArrayStack ---");
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        System.out.println("Top element (peek): " + arrayStack.peek());
        System.out.println("Popped item: " + arrayStack.pop());

        // Task 2 Test: LinkedStack
        System.out.println("\n--- Task 2: LinkedStack ---");
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(100);
        linkedStack.push(200);
        System.out.println("Top element (peek): " + linkedStack.peek());

        // Task 3 Test: Palindrome Checker
        System.out.println("\n--- Task 3: Palindrome Checker ---");
        System.out.println("Is 'level' palindrome? " + PalindromeChecker.isPalindrome("level"));
        System.out.println("Is 'hello' palindrome? " + PalindromeChecker.isPalindrome("hello"));

        // Task 4 Test: Balanced Parentheses
        System.out.println("\n--- Task 4: Balanced Parentheses ---");
        System.out.println("Is '{[()]}' balanced? " + BalancedParentheses.isBalanced("{[()]}"));
        System.out.println("Is '([)]' balanced? " + BalancedParentheses.isBalanced("([)]"));

        // Task 5 Test: Stack Sorter
        System.out.println("\n--- Task 5: Stack Sorter ---");
        Stack<Integer> unsorted = new Stack<>();
        unsorted.push(3);
        unsorted.push(1);
        unsorted.push(4);
        unsorted.push(2);
        System.out.println("Sorted Stack (Top to Bottom): " + StackSorter.sort(unsorted));

        // Bonus: MinStack Test
        System.out.println("\n--- Bonus Task: MinStack O(1) ---");
        MinStack mStack = new MinStack();
        mStack.push(5);
        mStack.push(3);
        mStack.push(7);
        System.out.println("Current Minimum: " + mStack.getMin());
    }
}
