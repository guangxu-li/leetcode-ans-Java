/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                if (i + dp[i + 1] + 1 < s.length() && s.charAt(i + dp[i + 1] + 1) == ')') {
                    dp[i] = 2 + dp[i + 1] + dp[i + dp[i + 1] + 2];
                }

                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
// @lc code=end
