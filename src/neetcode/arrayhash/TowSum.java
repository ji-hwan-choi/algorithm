package neetcode.arrayhash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제 : Two Sum
 * https://neetcode.io/problems/two-integer-sum?list=neetcode150
 */
public class TowSum {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1,3,4,2}, 6);

        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));

    }

    public static int[] solution(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];

            if (null != map.get(needValue) && i != map.get(needValue))
                return new int[]{i, map.get(needValue)};
        }

        return new int[]{-1, -1};
    }
}
