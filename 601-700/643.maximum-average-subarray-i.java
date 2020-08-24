/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int cur = max;

        for (int i = k; i < nums.length; i++) {
            cur += nums[i] - nums[i - k];
            max = Math.max(max, cur);
        }

        return (double) max / k;
    }
}
// @lc code=end

