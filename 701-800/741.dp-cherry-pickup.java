import java.util.Arrays;

/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start
class Solution {
    private static final int[][] dirs = new int[][] {{1, 1}, {1, 0}, {0, 1}, {0, 0}};

    public int cherryPickup(int[][] grid) { // O(n^3) and O(n^2)
        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[n - 1][n - 1] = grid[n - 1][n - 1];

        for (int layer = 2 * n - 3; layer >= 0; layer--) {
            for (int r1 = Math.max(0, layer - n + 1); r1 <= Math.min(layer, n - 1); r1++) {
                int c1 = layer - r1;
                for (int r2 = Math.max(0, layer - n + 1); r2 <= Math.min(layer, n - 1); r2++) {
                    int c2 = layer - r2;

                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        dp[r1][r2] = Integer.MIN_VALUE;
                        continue;
                    }

                    int cur = r1 == r2 ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];
                    int max = Integer.MIN_VALUE;

                    for (int[] dir : dirs) {
                        max = Math.max(max, cur + dp[r1 + dir[0]][r2 + dir[1]]);
                    }

                    dp[r1][r2] = max;
                }
            }
        }

        return Math.max(0, dp[0][0]);
    }
}
// @lc code=end

