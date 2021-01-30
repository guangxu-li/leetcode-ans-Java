/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start
class Solution {
    public int smallestDivisor(int[] nums, int threshold) { // O(n log(max))
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        int lo = Math.max(1, sum / threshold);
        int hi = max; // this is the key

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            sum = 0;
            for (int num : nums) {
                sum += num % mid == 0 ? num / mid : num / mid + 1;
            }

            if (sum > threshold) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
// @lc code=end

