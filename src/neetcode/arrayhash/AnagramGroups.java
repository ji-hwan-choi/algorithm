package neetcode.arrayhash;

import java.util.*;

/**
 * 문제 : Group Anagrams
 * https://neetcode.io/problems/anagram-groups?list=neetcode150
 */
public class AnagramGroups {
    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"});

        System.out.println("result.toString() = " + result.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);

            map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(strs[i]);
//            List<String> mapList = map.get(sortedKey);
//            if (null == mapList) {
//
//                List<String> list = new ArrayList<>();
//                list.add(strs[i]);
//                map.put(sortedKey, list);
//            } else {
//
//                mapList.add(strs[i]);
//            }

        }

//        for (String s : map.keySet())
//            result.add(map.get(s));

        return new ArrayList<>(map.values());
    }
}
