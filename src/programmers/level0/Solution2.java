package programmers.level0;

/**
 * 문제 : 정수를 나선형으로 배치하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181832
 *
 * 양의 정수 n이 매개변수로 주어집니다.
 * n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] solution = solution(5);
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 1;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;

        while (value <= n * n) {

            for (int i = colStart; i <= colEnd; i++) {
                answer[rowStart][i] = value++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                answer[i][colEnd] = value++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                answer[rowEnd][i] = value++;
            }
            rowEnd--;


            for (int i = rowEnd; i >= rowStart; i--) {
                answer[i][colStart] = value++;
            }
            colStart++;

        }

        return answer;
    }
}
