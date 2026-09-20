package utils;

import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
