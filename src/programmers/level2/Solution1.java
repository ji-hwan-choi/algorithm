package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 : 하샤드 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12947
 *
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        boolean result = s.solution("())");
        System.out.println("result = " + result);
    }

    public boolean solution(String s) {

        String[] split = s.split("");

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < split.length; i++) {

            if ("(".equals(split[i])) {
                stack.push(split[i]);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
