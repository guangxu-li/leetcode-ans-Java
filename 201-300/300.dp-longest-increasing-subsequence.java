/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for (int i = nums.length; i >= 0; i--) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (i == 0 || nums[j] > nums[i - 1]) {
                    dp[i][j] = 1 + dp[j + 1][j + 1];
                }

                dp[i][j] = Math.max(dp[i][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}
// @lc code=end

