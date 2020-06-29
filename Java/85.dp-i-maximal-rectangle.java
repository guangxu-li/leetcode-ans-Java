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

        int[][] dp = new int[matrix.length][matrix[0].length + 1];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i][j + 1] + 1;

                    maxArea = Math.max(maxArea, getMaxAreaAbove(dp, i, j));
                }
            }
        }

        return maxArea;
    }

    private int getMaxAreaAbove(int[][] dp, int row, int col) {
        int maxWidth = dp[row][col];
        int curHeight = 1;
        int maxArea = dp[row][col];
        for (int i = row; i >= 0 && maxWidth != 0; i--) {
            maxWidth = Math.min(maxWidth, dp[i][col]);
            curHeight = row - i + 1;
            maxArea = Math.max(maxArea, curHeight * maxWidth);
        }

        return maxArea;
    }
}
// @lc code=end

