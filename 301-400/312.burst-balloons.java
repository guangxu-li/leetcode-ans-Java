/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int[] ns = new int[nums.length + 2];
        ns[0] = 1;
        ns[ns.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            ns[i + 1] = nums[i];
        }

        int[][] dp = new int[ns.length][ns.length];

        for (int len = 1; len < ns.length - 1; len++) {
            for (int left = 0; left + len + 1 < ns.length; left++) {
                for (int i = left + 1; i < left + len + 1; i++) {
                    int m = left;
                    int n = left + len + 1;

                    dp[m][n] = Math.max(dp[m][n], dp[m][i] + dp[i][n] + ns[m] * ns[i] * ns[n]);
                }
            }
        }

        return dp[0][ns.length - 1];
    }
}
// @lc code=end

