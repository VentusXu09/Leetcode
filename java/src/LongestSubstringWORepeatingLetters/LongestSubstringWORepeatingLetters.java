package LongestSubstringWORepeatingLetters;

/**
 * Leetcode
 * Created by Ventus on 2019/12/24 10:38 PM
 */

public class Solution {
    public static void main() {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int result = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i-count-1, i-1);
            String s1 = s.substring(i, i);
            if (!sub.contains(s1)) {
                count++;
                if (count > result) result = count;
            } else {
                count = i - sub.indexOf(s.substring(i+1,i+1));
            }
        }

        return result;
    }
}
