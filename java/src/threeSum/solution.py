'''
Use dict to speed up search
'''
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res = set()

        for i,v in enumerate(nums):
            d = {}
            for j,w in enumerate(nums[i+1:]):
                if -v - w in d:
                    res.add((v, w, -v - w))
                d[w] = j

        return res