package neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 문제 : Largest Rectangle In Histogram
 * https://neetcode.io/problems/largest-rectangle-in-histogram?list=neetcode150
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {

        int result = largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
//        int result = largestRectangleArea(new int[]{1, 2, 1, 3, 2, 3, 4});
//        int result = largestRectangleArea(new int[]{5, 4, 3, 2, 1});
        System.out.println("result = " + result);

    }

    // 각 막대를 기준으로, 그 막대의 높이가 '최소 높이'가 되는 가장 넓은 직사각형을 찾는다.
    public static int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight = i == n ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight <= heights[stack.peek()]) {

                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);

            }

            stack.push(i);
        }

        return maxArea;
    }
}
