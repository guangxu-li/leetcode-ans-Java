/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int step = 0;

        for (int i = 0, range = 0, nextRange = 0; i < nums.length; i++) {
            if (i > range) {
                range = nextRange;
                step++;
            }

            nextRange = Math.max(nextRange, i + nums[i]);
        }

        return step;
    }
}
// @lc code=end

