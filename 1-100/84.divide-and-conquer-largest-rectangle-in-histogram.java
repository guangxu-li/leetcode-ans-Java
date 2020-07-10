/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }

    private int helper(int[] heights, int lo, int hi) {
        if (lo > hi) {
            return 0;
        }

        int minHeightIdx = getMinHeightIdx(heights, lo, hi);
        return Math.max(heights[minHeightIdx] * (hi - lo + 1), Math
                .max(helper(heights, lo, minHeightIdx - 1), helper(heights, minHeightIdx + 1, hi)));
    }

    private int getMinHeightIdx(int[] heights, int lo, int hi) {
        int idx = lo;
        while (lo <= hi) {
            if (heights[idx] > heights[lo]) {
                idx = lo;
            }

            lo++;
        }

        return idx;
    }
}
// @lc code=end

