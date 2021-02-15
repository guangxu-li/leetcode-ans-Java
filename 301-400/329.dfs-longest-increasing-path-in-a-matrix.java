/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m;
    private int n;

    private int[][] memo;

    private int getPathLen(int[][] matrix, int i, int j) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        int max = 1;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni < 0 || ni == m || nj < 0 || nj == n) {
                continue;
            }

            if (matrix[ni][nj] > matrix[i][j]) {
                max = Math.max(max, 1 + getPathLen(matrix, ni, nj));
            }
        }

        memo[i][j] = max;
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) { // O(mn) O(mn)
        this.m = matrix.length;
        this.n = matrix[0].length;

        this.memo = new int[m][n];

        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, getPathLen(matrix, i, j));
            }
        }

        return max;
    }
}
// @lc code=end

