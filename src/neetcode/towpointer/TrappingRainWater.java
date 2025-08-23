package neetcode.towpointer;

/**
 * 문제 : Trapping Rain Water
 * https://neetcode.io/problems/trapping-rain-water?list=neetcode150
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        int result = trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1});
        System.out.println("result = " + result);
    }

    public static int trap(int[] height) {

        int totalWater = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        while (leftIndex < rightIndex) {

            maxLeft = Math.max(maxLeft, height[leftIndex]);
            maxRight = Math.max(maxRight, height[rightIndex]);

            if (height[leftIndex] < height[rightIndex]) {
                totalWater = totalWater + (maxLeft - height[leftIndex]);
                leftIndex++;
            } else {
                totalWater = totalWater + (maxRight - height[rightIndex]);
                rightIndex--;
            }

        }
        return totalWater;
    }
}
