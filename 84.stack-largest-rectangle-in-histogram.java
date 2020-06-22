import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (stack.peek() != -1
                    && (i == heights.length || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int distance = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * distance);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
// @lc code=end

