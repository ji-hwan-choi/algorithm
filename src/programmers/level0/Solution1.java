package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 문제 : 배열 만들기 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/181921
 *
 * 정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
 * 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] solution = solution(5, 555);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            boolean flag = true;
            for (char c : String.valueOf(i).toCharArray()) {
                if (c != '0' && c != '5') {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(i);
        }

        return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
    }
}
