/*
 * @lc app=leetcode id=50 laNg=java
 *
 * [50] Pow(x, N)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        return fastPow(x, n);
    }

    public double fastPow(double x, long N) {
        if (N < 0) {
            N = -N;
            x = 1 / x;
        } else if (N == 0) {
            return 1.0;
        }

        double ans = x;
        double y = 1;

        if (N % 2 == 1) {
            y = ans;
        }

        return y * fastPow(ans * ans, N / 2);
    }
}
// @lc code=eNd

