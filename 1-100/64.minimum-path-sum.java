/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                if (row == n - 1 && col == m - 1) {
                    continue;
                }

                int down = row == n - 1 ? Integer.MAX_VALUE : grid[row + 1][col];
                int right = col == m - 1 ? Integer.MAX_VALUE : grid[row][col + 1];
                grid[row][col] += Math.min(down, right);
            }
        }

        return grid[0][0];
    }
}
// @lc code=end

