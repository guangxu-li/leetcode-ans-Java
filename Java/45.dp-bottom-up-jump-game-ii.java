/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = nums.length - 1;

            int step = nums[i];
            if (step == 0) {
                continue;
            } else if (i + step >= nums.length - 1) {
                dp[i] = 1;
            } else {
                for (int j = i + 1; j <= i + step; j++) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[0];
    }
}
// @lc code=end

