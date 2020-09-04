/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = 0;
        int localMax = 0;
        int localMin = 0;

        for (int num : nums) {
            int a = localMax;
            int b = localMin;

            localMax = Math.max(num, Math.max(a * num, b * num));
            localMin = Math.min(num, Math.min(a * num, b * num));

            globalMax = Math.max(localMax, localMin);
        }

        return globalMax;
    }
}
// @lc code=end

