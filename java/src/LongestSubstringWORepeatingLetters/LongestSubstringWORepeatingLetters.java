package LongestSubstringWORepeatingLetters;

/**
 * Leetcode
 * Created by Ventus on 2019/12/24 10:38 PM
 */

public class LongestSubstringWORepeatingLetters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int result = 1, count = 0;

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(i-count-1, i-1);
            String s1 = s.substring(i-1, i);
            if (!sub.contains(s1)) {
                count++;
                if (count > result) result = count;
            } else {
                int j = sub.indexOf(s1);
                count = count - j;
            }
        }

        return result;
    }
}
