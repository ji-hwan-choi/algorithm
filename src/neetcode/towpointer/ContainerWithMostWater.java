package neetcode.towpointer;

/**
 * 문제 : Container With Most Water
 * https://neetcode.io/problems/max-water-container?list=neetcode150
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        int result = maxArea(new int[]{1, 7, 2, 9, 4, 4, 3, 2});
        System.out.println("result = " + result);
    }

    public static int maxArea(int[] heights) {

        int i = 0;
        int j = heights.length - 1;
        int result = 0;

        while (i < j) {

            int h = Math.min(heights[i], heights[j]);
            int w = j - i;

            result = Math.max(result, h * w);

            if (heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return result;
    }
}
