/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int cur = 0;

        for (int num : nums) {
            int tmp = cur;
            cur = Math.max(prev + num, cur);
            prev = tmp;
        }

        return cur;
    }
}
// @lc code=end

