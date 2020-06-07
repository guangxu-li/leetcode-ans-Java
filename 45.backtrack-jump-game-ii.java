/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    private int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length + 1];

        return backtrack(nums, 0);
    }

    public int backtrack(int[] nums, int i) {
        if (dp[i] > 0) {
            return dp[i];
        }

        if (i >= nums.length - 1) {
            return 0;
        }

        int step = nums[i];
        if (i + step >= nums.length - 1) {
            dp[i] = 1;
            return 1;
        }

        int ans = nums.length;
        for (int idx = 1; idx <= step; idx++) {
            ans = Math.min(ans, 1 + backtrack(nums, i + idx));
        }

        dp[i] = ans;
        return ans;
    }
}
// @lc code=end

