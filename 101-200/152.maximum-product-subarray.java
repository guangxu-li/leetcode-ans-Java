/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int globalMax = nums[0];
        int localMax = 1;
        int localMin = 1;

        for (int num : nums) {
            int a = localMax * num;
            int b = localMin * num;

            localMax = Math.max(num, Math.max(a, b));
            localMin = Math.min(num, Math.min(a, b));

            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
// @lc code=end

