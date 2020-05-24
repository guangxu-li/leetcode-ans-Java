/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] sChars = s.toCharArray();

        int m = s.length();
        boolean[][] dp = new boolean[m][m];

        int maxLen = 0;
        int ans = 0; // record start index of s

        for (int len = 0; len < m; len++) {
            for (int start = 0; start + len < m; start++) {
                int end = start + len;
                if (len == 0) {
                    dp[start][end] = true;
                } else if (len == 1) {
                    dp[start][end] = (sChars[start] == sChars[end]);
                } else {
                    dp[start][end] = (sChars[start] == sChars[end] && dp[start + 1][end - 1]);
                }

                if (dp[start][end] && len + 1 > maxLen) {
                    ans = start;
                    maxLen = len + 1;
                }
            }
        }

        return maxLen == 0 ? "" : s.substring(ans, ans + maxLen);
    }
}
// @lc code=end
