package programmers.level0;

/**
 * 문제 : 피자 나눠 먹기 (2)
 * https://school.programmers.co.kr/learn/courses/30/lessons/120815
 *
 * 머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다.
 * 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
 * n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면
 * 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
 *
 * 최소 공배수 구하는 방법 :
 * 1. 유클리드 호재법으로 최대 공약수 계산
 * 2. (a * b) / 최대 공약수
 */
public class Solution7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        int result = s.solution(4);
        System.out.println("result = " + result);
    }

    public int solution(int n) {
        int piece = 6;
        return getLcm(n, piece) / piece;
    }

    public int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }


    public int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
