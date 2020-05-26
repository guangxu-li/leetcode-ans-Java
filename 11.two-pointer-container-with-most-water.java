/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int ans = 0;

        while (lo < hi) {
            int area = Math.min(height[lo], height[hi]) * (hi - lo);

            if (area > ans) {
                ans = area;
            }

            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }

        return ans;
    }
}
// @lc code=end
