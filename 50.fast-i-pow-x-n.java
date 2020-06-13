/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        double N = n;

        if (N < 0) {
            N = -N;
            x = 1 / x;
        } else if (N == 0) {
            return 1.0;
        }

        double ans = x;
        double y = 1.0;

        while (N > 1) {
            if (N % 2 == 1) {
                y *= ans;
                N--;
            }

            ans *= x;
            N /= 2.0;
        }

        return ans * y;
    }
}
// @lc code=end

