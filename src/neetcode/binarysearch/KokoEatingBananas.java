package neetcode.binarysearch;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 문제 : Koko Eating Bananas
 * https://neetcode.io/problems/eating-bananas?list=neetcode150
 */
public class KokoEatingBananas {
    public static void main(String[] args) {

        int result = minEatingSpeed(new int[]{25,10,23,4}, 4);
        System.out.println("result = " + result);
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int result = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (long) Math.ceil((double) pile / mid);
            }

            if (totalHours <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int minEatingSpeed2(int[] piles, int h) {
        int id = 0;
        OptionalInt maxOptional = Arrays.stream(piles).max();
        if(maxOptional.isEmpty()) return -1;

        int max = maxOptional.getAsInt();

        for (int i = 1; i <= max; i++) {

            long totalTiem = 0L;
            for (int j = 0; j < piles.length; j++) {
                id++;
                totalTiem += (long) Math.ceil((double) piles[j] / i);
            }

            if (totalTiem <= h) {
                System.out.println("id = " + id);
                return i;
            }
        }

        System.out.println("id = " + id);
        return max;
    }
}
