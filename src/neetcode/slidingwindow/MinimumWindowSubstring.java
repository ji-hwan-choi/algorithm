package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 : Minimum Window Substring
 * https://neetcode.io/problems/minimum-window-with-characters?list=neetcode150
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        String result = minWindow2("OUZODYXAZV", "XYZ");
        String result = minWindow2("ADOBECODEBANC", "ABC");
//        String result = minWindow2("ss", "s");
        System.out.println("result = " + result);
    }

    public static String minWindow2(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        int need = tMap.size();

        Map<Character, Integer> windowMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int left = 0;
        int have = 0;

        for (int right = 0; right < s.length(); right++) {

            if (tMap.containsKey(s.charAt(right))) {
                windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);

                if (tMap.get(s.charAt(right)).intValue() == windowMap.get(s.charAt(right)).intValue())
                    have++;
            }

            while (left <= right && need == have) {

                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minLeft = left;
                }

                if (tMap.containsKey(s.charAt(left))) {
                    if (tMap.get(s.charAt(left)).intValue() == windowMap.get(s.charAt(left)).intValue()) {
                        have--;
                    }
                    windowMap.put(s.charAt(left), windowMap.get(s.charAt(left)) - 1);
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLength + minLeft);
    }

    public static String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty() || s.length() < t.length()) {
            return "";
        }

        // t의 각 문자와 개수를 저장할 맵
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0; // 최소 윈도우의 시작 인덱스

        int have = 0; // 현재 윈도우가 만족하는 t의 고유 문자 수
        int need = tMap.size(); // 만족해야 할 t의 고유 문자 수

        // 현재 윈도우에 포함된 t의 문자들과 그 개수를 저장할 맵
        Map<Character, Integer> windowMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 윈도우에 현재 문자 추가
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                // 현재 문자의 개수가 t에서 필요한 개수와 일치하는지 확인
                if (windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                    have++;
                }
            }

            // 윈도우가 유효한 상태일 때, 축소 시작
            while (left <= right && have == need) {
                // 현재 윈도우 길이 확인 및 최소 길이 업데이트
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    minLeft = left;
                }

                // 윈도우의 왼쪽 문자 제거
                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    // 제거 전에 현재 문자의 개수가 t에서 필요한 개수와 같았다면,
                    // 제거 후에는 조건을 만족하지 못하게 되므로 have를 감소
                    if (windowMap.get(leftChar).intValue() == tMap.get(leftChar).intValue()) {
                        have--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++; // 윈도우 축소
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
