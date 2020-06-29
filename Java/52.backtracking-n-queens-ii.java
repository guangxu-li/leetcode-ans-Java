/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int SIZE;
    private int[] col;
    private int[] posDiag;
    private int[] negDiag;

    private int ans = 0; /* solutions found */

    public int totalNQueens(int n) {
        SIZE = n;
        col = new int[SIZE];
        posDiag = new int[2 * SIZE]; /* 2 * SIZE - 1 groups of diag */
        negDiag = new int[2 * SIZE]; /* in case SIZE = 0 */

        backtrack(n);

        return ans;
    }

    private void backtrack(int n) {
        if (n == 0) {
            ans++;
        } else {
            for (int i = 0; i < SIZE; i++) {
                int posIdx = i - n + SIZE;
                int negIdx = i + n - 1;

                if (col[i] + negDiag[negIdx] + posDiag[posIdx] == 0) {
                    col[i] = 1;
                    posDiag[posIdx] = 1;
                    negDiag[negIdx] = 1;

                    backtrack(n - 1);

                    col[i] = 0;
                    posDiag[posIdx] = 0;
                    negDiag[negIdx] = 0;
                }
            }
        }
    }
}
// @lc code=end

