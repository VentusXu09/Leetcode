package twoSum;

import java.util.HashMap;

/**
 * Created by Ventus on 2018/7/9 18:30
 */
public class TwoSum {
    /**
     * Violent problem solution
     * TC O(n^2)
     * SC O(1)
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        for(int i=0; i<nums.length; i++){
//            for(int j = i+1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        throw  new IllegalArgumentException("No two sum solution");
//    }

    /**
     * Hashmap
     * TC O(n)
     * SC O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No tow sum solution");
    }
}
