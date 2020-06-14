/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int loRow = 0;
        int hiRow = n - 1;

        int loCol = 0;
        int hiCol = n - 1;

        int num = 1;

        while (loRow <= hiRow && loCol <= hiCol) {
            for (int i = loRow; i <= hiCol; i++) {
                ans[loRow][i] = num++;
            }

            for (int i = loRow + 1; i <= hiRow; i++) {
                ans[i][hiCol] = num++;
            }

            for (int i = hiCol - 1; i >= loCol; i--) {
                ans[hiRow][i] = num++;
            }

            for (int i = hiRow - 1; i > loRow; i--) {
                ans[i][loCol] = num++;
            }

            loRow++;
            hiRow--;

            loCol++;
            hiCol--;
        }

        return ans;
    }
}
// @lc code=end
