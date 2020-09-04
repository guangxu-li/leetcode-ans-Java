/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    private Integer[][] cache;

    private int dfs(int[] nums, int pos, Integer prev) {
        if (cache[prev + 1][pos] != null) {
            return cache[prev + 1][pos];
        }

        int max = 0;
        if (pos == nums.length) {
            return max;
        } else {
            if (prev == -1 || nums[pos] > nums[prev]) {
                max = 1 + dfs(nums, pos + 1, pos);
            }

            max = Math.max(max, dfs(nums, pos + 1, prev));
        }

        cache[prev + 1][pos] = max;
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        this.cache = new Integer[nums.length + 1][nums.length + 1];

        return dfs(nums, 0, -1);
    }
}
// @lc code=end

