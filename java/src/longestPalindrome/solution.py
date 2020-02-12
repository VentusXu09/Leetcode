class Solution(object):
    def longestPalindrome(self, s : str)-> str:
        if not s:
            return s;
        n = len(s)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        longest = 1;
        r = s[0:1]

        for length in range(1,n+1):
            for i in range(0,n-length+1):
                j = i + length - 1;
                if length == 1:
                    dp[i][j] = 1
                elif s[i] == s[j]:
                    if length == 2 or dp[i+1][j-1] > 0:
                        dp[i][j]=1
                        if length > longest:
                            longest = length
                            r = s[i:i+longest]
        return r

solution = Solution()
print(solution.longestPalindrome("cddb"))



