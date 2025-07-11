package programmers.level0;

/**
 * 문제 : 분수의 덧셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/120808
 *
 * 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
 * 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 *
 * 최대공약수 구하는 방법 : 유클리드 호제법 사용 ( gcd1(), gcd2() )
 *
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
//        int[] solution = s.solution(9,2,1,3);
        int[] solution = s.solution(12,32,124,54);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = (numer1 * denom2) + (denom1 * numer2);
        int denom = denom1 * denom2;

        int gcd = gdc1(numer, denom);
        return new int[]{numer / gcd, denom / gcd};
    }

    private int gdc1(int numer, int denom) {
        if (denom == 0) return numer;
        return gdc1(denom, numer % denom);
    }

    private int gdc2(int numer, int denom) {
        while (denom != 0) {
            int temp = denom;
            denom = numer % denom;
            numer = temp;
        }
        return numer;
    }
}
