/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        int y = 0;
        for (int num : nums) {
            x = ~y & (x ^ num);
            y = ~x & (y ^ num);
        }

        return y;
    }
}
// @lc code=end

