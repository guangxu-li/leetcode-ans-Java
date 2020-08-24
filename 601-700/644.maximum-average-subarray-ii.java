/*
 * @lc app=leetcode id=644 lang=java
 *
 * [644] Maximum Average Subarray II
 */

// @lc code=start
class Solution {
    private boolean hasBiggerAverage(int[] nums, int k, double avg) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - avg;
        }

        if (sum >= 0) {
            return true;
        }

        double prefix = 0;
        for (int i = k; i < nums.length; i++) {
            prefix += nums[i - k] - avg;
            sum += nums[i] - avg;

            if (prefix < 0) {
                sum -= prefix;
                prefix = 0;
            }

            if (sum >= 0) {
                return true;
            }
        }

        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double lo = 0;
        double hi = 0;
        for (int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }

        while (lo + 0.00001 < hi) {
            double mid = (lo + hi) / 2;

            if (hasBiggerAverage(nums, k, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
// @lc code=end

