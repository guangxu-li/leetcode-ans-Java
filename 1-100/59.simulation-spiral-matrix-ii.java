/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};

        int[][] ans = new int[n][n];

        int row = 0;
        int col = 0;
        int dir = 0;

        for (int i = 1; i <= n * n; i++) {
            if (ans[row][col] == 0) {
                ans[row][col] = i;
            }

            int nextRow = row + dirRow[dir];
            int nextCol = col + dirCol[dir];

            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
                    && ans[nextRow][nextCol] == 0) {
                row = nextRow;
                col = nextCol;
            } else {
                dir = (dir + 1) % 4;

                row += dirRow[dir];
                col += dirCol[dir];
            }
        }

        return ans;
    }
}
// @lc code=end

