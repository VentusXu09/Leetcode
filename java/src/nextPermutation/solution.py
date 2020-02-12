class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(len(nums)-1, 0, -1):
            if nums[i] > nums[i-1]:
                index = i
                j = i
                while j < len(nums):
                    if nums[j] > nums[i-1] and nums[j] < nums[index]:
                        index = j
                    j+=1
                nums[i-1], nums[index] = nums[index], nums[i-1]
                nums[i:] = sorted(nums[i:])
                return
        nums.sort()