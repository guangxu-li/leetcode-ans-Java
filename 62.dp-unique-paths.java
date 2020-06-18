/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m + 1];
        dp[m - 1] = 1;

        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                dp[col] = dp[col] + dp[col + 1];
            }
        }
        return dp[0];
    }
}
// @lc code=end

