/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start
class Solution {
    private Integer[][][] memo;
    private int[][] grid;
    private int n = 0;

    private int[][] dirs = new int[][] {{1, 0, 1, 0}, {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 1}};

    // the key is at the point (n - 1, n - 1) and (n - 1, n - 1) should return the value directly;
    private int dfs(int r1, int c1, int r2, int c2) {
        if (memo[r1][c1][r2] != null) {
            return memo[r1][c1][r2];
        }

        int min = Integer.MIN_VALUE;

        if (r1 != n && c1 != n && r2 != n && c2 != n && grid[r1][c1] != -1 && grid[r2][c2] != -1) {
            int cur = r1 == r2 ? grid[r1][c1] : grid[r1][c1] + grid[r2][c2];
            for (int[] dir : dirs) {
                min = Math.max(min, cur + dfs(r1 + dir[0], c1 + dir[1], r2 + dir[2], c2 + dir[3]));
            }
        }

        memo[r1][c1][r2] = min;
        return min;
    }

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        this.memo = new Integer[n + 1][n + 1][n + 1];
        memo[n - 1][n - 1][n - 1] = grid[n - 1][n - 1];

        return Math.max(0, dfs(0, 0, 0, 0));
    }
}
// @lc code=end

