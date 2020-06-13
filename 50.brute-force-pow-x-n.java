/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        double N = n;

        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        for (double i = 0.0; i < N; i++) {
            ans *= x;
        }

        return ans;
    }
}
// @lc code=end

