/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] left = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }

        int[] right = new int[nums.length];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((i + 1) % k == 0) {
                right[i] = nums[i];
            } else {
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }

        int[] maxNums = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            maxNums[i] = Math.max(right[i], left[i + k - 1]);
        }

        return maxNums;
    }
}
// @lc code=end

