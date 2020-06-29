/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int localMax = Integer.MIN_VALUE;
        int globalMax = Integer.MIN_VALUE;

        for (int num : nums) {
            if (localMax < 0) {
                localMax = num;
            } else {
                localMax += num;
            }

            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
// @lc code=end

