/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                if (row == n - 1 && col == m - 1) {
                    obstacleGrid[row][col] ^= 1;
                } else if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else if (row == n - 1) {
                    obstacleGrid[row][col] += obstacleGrid[row][col + 1];
                } else if (col == m - 1) {
                    obstacleGrid[row][col] += obstacleGrid[row + 1][col];
                } else {
                    obstacleGrid[row][col] += obstacleGrid[row][col] == 1 ? 0
                            : obstacleGrid[row + 1][col] + obstacleGrid[row][col + 1];
                }
            }
        }

        return obstacleGrid[0][0];
    }
}
// @lc code=end

