/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int num : nums) {
            localMax = Math.max(0, localMax) + num;
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }
}
// @lc code=end

