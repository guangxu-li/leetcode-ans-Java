/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    private int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[2][2];

        res[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        res[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        res[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        res[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];

        return res;
    }

    private int[][] matrixPower(int[][] a, int n) {
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return multiply(a, a);
        }

        int[][] res = matrixPower(matrixPower(a, n / 2), 2);

        return n % 2 == 1 ? multiply(res, new int[][] {{1, 1}, {1, 0}}) : res;
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[][] a = new int[][] {{1, 1}, {1, 0}};
        return matrixPower(a, n - 1)[0][0];
    }
}
// @lc code=end

