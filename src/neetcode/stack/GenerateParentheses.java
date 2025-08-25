package neetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 : Generate Parentheses
 * https://neetcode.io/problems/generate-parentheses?list=neetcode150
 */
public class GenerateParentheses {
    public static void main(String[] args) {

        List<String> result = generateParenthesis(3);
        System.out.println("result = " + result);

    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backTrack(result, "", 0, 0, n);

        return result;
    }

    private static void backTrack(List<String> result, String currentString, int open, int close, int n) {

        if (close == n) {
            result.add(currentString);
            return;
        }

        if (open < n)
            backTrack(result, currentString + "(", open + 1, close, n);

        if (close < open)
            backTrack(result, currentString + ")", open, close + 1, n);
    }
}
