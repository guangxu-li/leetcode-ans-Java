/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }

        return a;
    }
}
// @lc code=end

