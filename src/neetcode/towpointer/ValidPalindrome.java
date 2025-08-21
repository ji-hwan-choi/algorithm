package neetcode.towpointer;

/**
 * 문제 : Valid Palindrome
 * https://neetcode.io/problems/is-palindrome?list=neetcode150
 *
 * Character.isLetter() : 값이 문자인지 boolean return
 * Character.Digit() : 값이 숫자인지 boolean return
 * Character.isLetterOrDigit() : 값이 문자 혹은 숫자인지 boolean return
 *
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        boolean result = isPalindrome("tab a cat");

        System.out.println("result = " + result);
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(chars[i]))
                i++;
            else if (!Character.isLetterOrDigit(chars[j]))
                j--;
            else if (Character.toLowerCase(chars[i++]) != Character.toLowerCase(chars[j--]))
                return false;
        }

        return true;
    }
}
