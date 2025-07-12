package programmers.level0;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * 문제 : 짝수는 싫어요
 * https://school.programmers.co.kr/learn/courses/30/lessons/120813
 *
 * 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
 *
 * IntStream.rangeClosed() 사용법 확인하기
 */
public class Solution6 {
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        int[] solution = s.solution(10);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public int[] solution(int n) {
        return IntStream.rangeClosed(1, n).filter(v -> v % 2 == 1).toArray();
    }
}
