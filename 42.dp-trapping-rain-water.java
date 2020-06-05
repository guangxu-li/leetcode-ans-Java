/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    private int[] leftMax;
    private int[] rightMax;

    private int height[];
    private int size;

    public void getMax() {
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
    }

    public int trap(int[] height) {
        int ans = 0;

        this.height = height;
        this.size = height.length;

        if (size == 0) {
            return 0;
        }

        leftMax = new int[size];
        rightMax = new int[size];

        getMax();

        for (int i = 0; i < size; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
// @lc code=end
