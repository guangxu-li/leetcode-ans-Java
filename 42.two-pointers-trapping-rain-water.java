/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;

        int lo = 0;
        int hi = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (lo < hi) {
            if (height[lo] < height[hi]) {
                if (height[lo] >= leftMax) {
                    leftMax = height[lo];
                } else {
                    ans += leftMax - height[lo];
                }

                lo++;
            } else {
                if (height[hi] >= rightMax) {
                    rightMax = height[hi];
                } else {
                    ans += rightMax - height[hi];
                }

                hi--;
            }
        }

        return ans;
    }
}
// @lc code=end

