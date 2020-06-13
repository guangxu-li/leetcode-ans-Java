/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = true;
            } else if (nums[i] == 0) {
                dp[i] = false;
            } else {
                for (int j = i + 1; j <= i + nums[i] && !dp[i]; j++) {
                    dp[i] = dp[i] || dp[j];
                }
            }
        }

        return dp[0];
    }
}
// @lc code=end

