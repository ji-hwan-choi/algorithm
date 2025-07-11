package programmers.level0;

import java.util.Arrays;

/**
 * 문제 : 배열 두 배 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120809
 *
 * 정수 배열 numbers가 매개변수로 주어집니다.
 * numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] solution = s.solution(new int[]{1, 2, 100, -99, 1, 2, 3});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers)
                .map(i -> i * 2)
                .toArray();
    }
}
