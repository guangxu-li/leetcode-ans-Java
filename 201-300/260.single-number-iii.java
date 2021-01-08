/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;

        for (int num : nums) {
            bitmask ^= num;
        }

        int diff = bitmask & (-bitmask);

        int candidate = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                candidate ^= num;
            }
        }

        return new int[] {candidate, candidate ^ bitmask};
    }
}
// @lc code=end

