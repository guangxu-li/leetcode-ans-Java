/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;

        for (int i = 0; i < height.length; i++) {
            leftMax = getMax(height, 0, i);
            rightMax = getMax(height, i, height.length - 1);

            int bound = Math.min(leftMax, rightMax);
            ans += bound - height[i];
        }

        return ans;
    }

    public int getMax(int[] height, int start, int end) {
        int max = 0;

        for (int i = start; i <= end; i++) {
            max = Math.max(max, height[i]);
        }

        return max;
    }
}
// @lc code=end
