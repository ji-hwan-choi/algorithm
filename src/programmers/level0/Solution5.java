package programmers.level0;

import java.util.HashMap;

/**
 * 문제 : 최빈값 구하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/120812
 *
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.
 *
 * 최빈값은 HashMap 활용하기.
 * getOrDefault(a, b) : get 한 값이 null 일 경우, b값으로.
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        int result = s.solution(new int[]{1, 2, 3, 3, 3, 4});
        System.out.println("result = " + result);
    }

    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int maxCount = 0;

        for (Integer num : array) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (maxCount < count) {
                answer = num;
                maxCount = count;
            } else if (maxCount == count) {
                answer = -1;
            }
        }

        return answer;
    }
}
