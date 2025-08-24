package neetcode.stack;

import java.util.*;

/**
 * 문제 : Valid Parentheses
 * https://neetcode.io/problems/validate-parentheses?list=neetcode150
 */
public class ValidParentheses {
    public static void main(String[] args) {

        boolean result = isValid("([{}])");
        System.out.println("result = " + result);
    }

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }
}
