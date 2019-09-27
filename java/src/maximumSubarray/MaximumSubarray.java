package maximumSubarray;

/**
 * Leetcode 53 Maximum Subarray
 * Created by Ventus on 2019/9/19 3:59 PM
 */


/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Tags: Array, Divide and Conquer, Dynamic Programming
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,0};
        int max = maxSubArray(nums);
        System.out.println(max);

    }

    public static int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    /**
     * Solving the problem with Divide and Conquer method
     * When we divide arrays into two parts, we need to compare
     * @param nums input subarrays
     * @param left left flag
     * @param right right flag
     * @return max Subarray sum in nums[left : right]
     */
    public static int divideAndConquer(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int left_sum = divideAndConquer(nums, left, mid);
        int right_sum = divideAndConquer(nums, mid + 1, right);
        int left_max = nums[mid], right_max = nums[mid+1];
        int temp = 0;
        for (int i = mid; i>left; i--) {
            temp += left_max;
            left_max = temp > left_max ? temp : left_max;
        }
        temp = 0;
        for (int i = mid +1; i < right; i++) {
            temp += nums[i];
            right_max = temp > right_max ? temp : right_max;
        }

        return Math.max(Math.max(right_sum, left_sum), left_max + right_max);
    }

    /**
     * Dynamic Programming
     * @return max Subarray sum
     */
    public static int dynamicProgramming(int[] nums) {
        int len = nums.length , dp = nums[0], max = dp;
        for (int i = 1; i < len; i++) {
            dp = dp > 0 ? dp + nums[i] : 0;
            if (dp > max) {
                max = dp;
            }
        }
        return max;
    }
}
