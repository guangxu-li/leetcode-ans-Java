/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[] dp = new int[matrix[0].length + 1];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length + 1];
        int top = 0; /* serve as stack top pointer */
        stack[top] = -1;

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack[top] != -1 && heights[i] <= heights[stack[top]]) {
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

