package subarraySumEqualsK;

import java.util.HashMap;

/**
 * Created by Ventus on 2018/7/9 18:29
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Note:
 * 1. The length of the array is in range [1, 20,000].
 * 2. The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 */
public class SubarraySumEqualsK {

    public static void main(String[] args){
        int[] a =  {1, 2, 1, -2, 3, -1, -1};
        System.out.println(new SubarraySumEqualsK().subarraySum(a,2));
    }

    /**
     * Little cost with HashMap
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i : nums){
            sum += i;
            Integer count = map.get(sum);
            if (count == null){
                map.put(sum, 1);
            } else {
                map.put(sum, count+1);
            }
        }
        sum = 0;
        int result = 0;
        for (int i : nums){
            int key = sum + k;
//            int count = map.get(key);
            if (map.containsKey(key)){
                int count = map.get(key);
                result += count;
            }
            sum += i;
            if (map.containsKey(sum)){
                int count = map.get(sum);
                if (count > 1){
                    map.put(sum, count - 1);
                } else {
                    map.remove(sum);
                }
            }
        }
        return result;
    }

}
