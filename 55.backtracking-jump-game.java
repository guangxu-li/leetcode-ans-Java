/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {

        return backtrack(nums, 0);
    }

    public boolean backtrack(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            return true;
        }

        for (int i = pos + 1; i <= nums[pos] + pos; i++) {
            if (backtrack(nums, i)) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

