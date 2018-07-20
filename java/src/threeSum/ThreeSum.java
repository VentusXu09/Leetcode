package threeSum;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode
 * Created by xuxiaofeng on 2018/7/10 8:11 PM
 */
public class ThreeSum {

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Solution.threeSum(nums));

    }

    public static class Solution{

        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();

            int n = nums.length;
            if (n < 3) return list;

            Arrays.sort(nums);
            int max = nums[n-1];
            if (max < 0) return list;

            for (int i = 0; i < n - 2; ){
                if (nums[i] > 0) break;
                if (nums[i] + 2 * max < 0) {

                    while (nums[i] == nums[++i] && i < n - 2);
                    continue;

                }
                int left = i + 1, right = n - 1;
                while (left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0){
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (nums[left] == nums[++left] && left < right);
                        while (nums[right] == nums[--right] && left < right);
                    } else if ( sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (nums[i] == nums[++i] && i < n - 2){
                    if(i == 1)System.out.println("1");
                }
            }
            return list;
        }
    }
}
