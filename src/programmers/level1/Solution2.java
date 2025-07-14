package programmers.level1;

/**
 * 문제 : 정수 제곱근 판별
 * https://school.programmers.co.kr/learn/courses/30/lessons/12934
 *
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 * Math.sqrt(n) : 제곱근 구하기 (121은 x의 제곱)
 * Math.pow(a, b) : a의 b 제곱 구하기
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        long result = s.solution(121);
        System.out.println("result = " + result);
    }

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt % 1 == 0 ? (long) Math.pow(sqrt + 1, 2) : -1;
    }
}
