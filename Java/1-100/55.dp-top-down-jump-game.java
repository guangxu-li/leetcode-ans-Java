/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    private int[] dp;

    public boolean canJump(int[] nums) {
        dp = new int[nums.length];

        return helper(nums, 0) == 1;
    }

    public int helper(int[] nums, int pos) {
        if (dp[pos] != 0) {
            return dp[pos];
        }

        if (pos == nums.length - 1) {
            dp[pos] = 1;
            return 1;
        }

        int ans = -1;
        for (int i = pos + 1; i <= pos + nums[pos]; i++) {
            if (helper(nums, i) == 1) {
                ans = 1;
                break;
            }
        }

        dp[pos] = ans;
        return ans;
    }
}
// @lc code=end

