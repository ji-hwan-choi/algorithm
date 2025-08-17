package neetcode.arrayhash;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 : Encode and Decode Strings
 * https://neetcode.io/problems/string-encode-and-decode?list=neetcode150
 */
public class EncodeAndDecodeStrings {
    public static void main(String[] args) {

        EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();
        String encode = encodeAndDecodeStrings.encode(List.of("neet", "code", "love", "you"));
        List<String> decode = encodeAndDecodeStrings.decode(encode);

        System.out.println("decode = " + decode.toString());
    }

    public String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for (String s : strs)
            encodedString.append(s.length()).append('#').append(s);

        return encodedString.toString();
    }

    public List<String> decode(String s) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = s.indexOf('#', i);

            int length = Integer.parseInt(s.substring(i, j));

            String originalStr = s.substring(j + 1, j + 1 + length);
            decodedList.add(originalStr);

            i = j + 1 + length;
        }

        return decodedList;
    }
}
