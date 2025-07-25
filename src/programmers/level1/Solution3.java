package programmers.level1;

import java.util.*;

/**
 * 문제 : 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 *
 * 네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 * 입출력 예
 * 1. "one4seveneight" -> 1478
 * 2. "23four5six7"    -> 234567
 *
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int result = s.solution("one4seveneightone");
        System.out.println("result = " + result);
    }

    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strArr.length; i++) {
            s = s.replace(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
