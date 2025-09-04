package neetcode.binarysearch;

/**
 * 문제 : Binary Search
 * https://neetcode.io/problems/binary-search?list=neetcode150
 */
public class BinarySearch {

    public static void main(String[] args) {

        int result = search(new int[]{-1, 0, 2, 4, 6, 8}, 3);
//        int result = search(new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8}, 8);
        System.out.println("result = " + result);
    }

    public static int search(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[midIndex] == target)
                return midIndex;

            else if (nums[midIndex] < target)
                startIndex = midIndex + 1;

            else
                endIndex = midIndex - 1;
        }

        return -1;
    }

    public static int searchRecursive(int[] nums, int startIndex, int endIndex, int target) {

        if (endIndex < startIndex) return -1;

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        if (nums[midIndex] == target)
            return midIndex;

        else if (nums[midIndex] < target)
            return searchRecursive(nums, midIndex + 1, endIndex, target);

        else
            return searchRecursive(nums, startIndex, midIndex - 1, target);
    }
}
