/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length + 2]; /* 1. push -1, 2. end phase*/
        int top = 0; /* serve as stack top pointer */
        stack[top] = -1;

        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (stack[top] != -1 && (i == heights.length || heights[i] <= heights[stack[top]])) {
                int height = heights[stack[top--]];
                int distance = i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * distance);
            }

            stack[++top] = i;
        }

        return maxArea;
    }
}
// @lc code=end

