/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int i = binarySearch(dp, 0, len - 1, num);
            dp[i] = num;

            if (i == len) {
                len++;
            }
        }

        return len;
    }
}
// @lc code=end

