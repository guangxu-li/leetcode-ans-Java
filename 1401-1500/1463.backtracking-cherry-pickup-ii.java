/*
 * @lc app=leetcode id=1463 lang=java
 *
 * [1463] Cherry Pickup II
 */

// @lc code=start
class Solution {
    private int[][] grid;
    private int m = 0;
    private int n = 0;

    private Integer[][][] memo;

    private int pickup(int r, int c1, int c2) {
        if (memo[r][c1][c2] != null) {
            return memo[r][c1][c2];
        }

        int cur = grid[r][c1] + grid[r][c2];
        if (r == m - 1) {
            return cur;
        }
        
        int max = 0;
        for (int i = Math.max(0, c1 - 1); i <= Math.min(n - 1, c1 + 1); i++) {
            for (int j = Math.max(0, c2 - 1); j <= Math.min(n - 1, c2 + 1); j++) {
                if (i == j) {
                    continue;
                }

                max = Math.max(max, pickup(r + 1, i, j));
            }
        }

        memo[r][c1][c2] = max + cur;
        return max + cur;
    }

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        this.memo = new Integer[m][n][n];

        return pickup(0, 0, n - 1);
    }
}
// @lc code=end

