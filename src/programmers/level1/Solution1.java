package programmers.level1;

/**
 * 문제 : 하샤드 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12947
 *
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
 * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 *
 * char -> int 로 형 변환 하는 방법 체크
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        boolean result = s.solution(12);
        System.out.println("result = " + result);
    }

    public boolean solution(int x) {
        int sum = 0;
        for (char c : String.valueOf(x).toCharArray())
            sum += Character.getNumericValue(c);
        return x % sum == 0;
    }
}
