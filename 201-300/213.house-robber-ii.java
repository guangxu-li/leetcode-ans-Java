/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    private int helper(int[] nums, int lo, int hi) {
        int max = 0;
        int skip = 0;

        while (hi >= lo) {
            int tmp = max;
            max = Math.max(nums[hi--] + skip, max);
            skip = tmp;
        }

        return max;
    }

    public int rob(int[] nums) {
        return nums.length == 1 ? nums[0] : Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
}
// @lc code=end

