package longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        String s = "qwerwweqrxnqwe";
        System.out.println(Solution.lengthOfLongestSubstring2(s));

    }

    public static class Solution{

        /**
         * HashSet slide window
         * TC: O(n)
         * SC: O(min(m,n))
         * @param s
         * @return
         */
        public static int lengthOfLongestSubstring(String s) {
            int result = 0;

            HashSet<Character> set = new HashSet<>();
            int i =0, j = 0, n = s.length();
            while(i < n && j < n){
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    result =  result > (j-i) ? result : (j-i);
                } else {
                    set.remove(s.charAt(i++));
                }
            }
            return result;

        }

        /**
         * HashMap slide window
         * TC: O(n)
         * SC: O(min(m,n))
         * @param s
         * @return
         */
        public static int lengthOfLongestSubstring2(String s) {
            int result = 0;

            HashMap<Character, Integer> map = new HashMap<>();
            int n = s.length();
            for(int i = 0, j = 0; j< n; j++){
                if(map.containsKey(s.charAt(j))){
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                result = Math.max(result, j-i+1);
                map.put(s.charAt(j), j+1);
            }
            return result;
        }
    }
}
