package neetcode.slidingwindow;

import java.util.Arrays;

/**
 * 문제 : Permutation in String
 * https://neetcode.io/problems/permutation-string?list=neetcode150
 */
public class PermutationinString {

    public static void main(String[] args) {

//        boolean result = checkInclusion("abc", "lecabee");
//        boolean result = checkInclusion("abc", "lecaabee");
        boolean result = checkInclusion("adc", "dcda");
        System.out.println("result = " + result);
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {

            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}
