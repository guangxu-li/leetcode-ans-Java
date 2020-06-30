/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;

        int leftSum = helper(nums, lo, mid);
        int crossSum = helper(nums, lo, mid, hi);
        int rightSum = helper(nums, mid + 1, hi);

        return Math.max(Math.max(leftSum, crossSum), rightSum);
    }

    /* Overload helper for calculating crossSum*/
    public int helper(int[] nums, int lo, int mid, int hi) {
        int leftSubSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            leftSubSum = Math.max(leftSubSum, sum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= hi; i++) {
            sum += nums[i];
            rightSubSum = Math.max(rightSubSum, sum);
        }

        return leftSubSum + rightSubSum;
    }
}
// @lc code=end

