'''
Greed Algorithm to improve time performance
'''
class Solution:
    def maxArea(self, height: List[int]) -> int:

        if not height:
            return height
        mx = 0
        n = len(height)

        i = 0
        j = n-1

        while(i <= j):
            h = min(height[i], height[j])
            area = h * (j-i)
            mx = max(mx, area)

            l = height[i]
            r = height[j]

            if l < r:
                while(i < j and l > height[i+1]):
                    i += 1
                else:
                    i += 1
            else:
                while(i < j and r > height[j-1]):
                    j -= 1
                else:
                    j -= 1

        return mx

solution = Solution()
print(solution.maxArea([1,8,6,2,5,4,8,3,7]))
