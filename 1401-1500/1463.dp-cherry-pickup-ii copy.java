/*
 * @lc app=leetcode id=1463 lang=java
 *
 * [1463] Cherry Pickup II
 */

// @lc code=start
class Solution {
    public int cherryPickup(int[][] grid) { // O(m * n^2) O(m * n^2)
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m + 1][n][n];

        for (int r = m - 1; r >= 0; r--) {
            for (int c1 = 0; c1 <= Math.min(r, n - 1); c1++) {
                for (int c2 = Math.max(0, n - 1 - r); c2 < n; c2++) {
                    if (c1 == c2) {
                        continue;
                    }

                    for (int i = Math.max(0, c1 - 1); i <= Math.min(n - 1, c1 + 1); i++) {
                        for (int j = Math.max(0, c2 - 1); j <= Math.min(n - 1, c2 + 1); j++) {
                            dp[r][c1][c2] = Math.max(dp[r][c1][c2],
                                    grid[r][c1] + grid[r][c2] + dp[r + 1][i][j]);
                        }
                    }
                }
            }
        }

        return dp[0][0][n - 1];
    }
}
// @lc code=end

