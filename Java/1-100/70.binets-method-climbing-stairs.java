/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] qn = matrixPow(q, n);

        return qn[0][0];
    }

    private int[][] matrixPow(int[][] q, int n) {
        int[][] y = {{1, 0}, {0, 1}};

        while (n > 0) {
            if ((n & 1) == 1) {
                y = matrixMultiply(y, q);
            }

            q = matrixMultiply(q, q);
            n >>= 1;
        }

        return y;
    }

    private int[][] matrixMultiply(int[][] p, int[][] q) {
        int[][] res = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = p[i][0] * q[0][j] + p[i][1] * q[1][j];
            }
        }

        return res;
    }
}
// @lc code=end

