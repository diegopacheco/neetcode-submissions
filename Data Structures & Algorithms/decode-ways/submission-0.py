class Solution:
    def numDecodings(self, s: str) -> int:
        a, b = 0, 1
        for i in range(len(s)):
            cur = b if s[i] != '0' else 0
            if i > 0 and '10' <= s[i-1:i+1] <= '26':
                cur += a
            a, b = b, cur
        return b