/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[cs.length][cs.length];

        int lo = 0;
        int hi = -1;
        for (int len = 0; len < cs.length; len++) {
            for (int start = 0; start + len < cs.length; start++) {
                if (len == 0) {
                    dp[len][start] = true;
                } else if (len == 1) {
                    dp[len][start] = cs[start] == cs[start + 1];
                } else {
                    dp[len][start] = cs[start] == cs[start + len] && dp[len - 2][start + 1];
                }

                if (dp[len][start] && len > hi - lo) {
                    lo = start;
                    hi = start + len;
                }
            }
        }

        return s.substring(lo, hi + 1);
    }
}
// @lc code=end

