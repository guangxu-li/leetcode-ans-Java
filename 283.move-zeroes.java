/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int lo = 0;

        for (int hi = 0; hi < nums.length; hi++) {
            if (nums[hi] != 0) {
                if (lo != hi) {
                    nums[lo] = nums[hi];
                    nums[hi] = 0;
                }

                lo++;
            }
        }
    }
}
// @lc code=end

