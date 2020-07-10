/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int hi = nums[0];

        for (int i = 0; i <= hi && hi < nums.length - 1; i++) {
            hi = Math.max(hi, i + nums[i]);
        }

        return hi >= nums.length - 1;
    }
}
// @lc code=end

