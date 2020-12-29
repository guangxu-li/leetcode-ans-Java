/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0;
        int hi = 0;

        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi];

            while (sum >= s) {
                len = Math.min(len, hi - lo + 1);
                sum -= nums[lo++];
            }

            hi++;
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
// @lc code=end

