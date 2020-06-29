/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    private static int HALF_INT_MIN = -1073741824;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int op = -1;
        if (dividend > 0) {
            dividend = -dividend;
        } else {
            op = -op;
        }

        if (divisor > 0) {
            divisor = -divisor;
        } else {
            op = -op;
        }

        int maxBit = 0;
        while (divisor >= HALF_INT_MIN && dividend <= divisor + divisor) {
            maxBit++;
            divisor += divisor;
        }

        int quotient = 0;

        for (int bit = maxBit; bit >= 0; bit--) {
            if (dividend <= divisor) {
                quotient -= (1 << bit);
                dividend -= divisor;
            }

            divisor = (divisor + 1) >> 1;
        }

        return op == -1 ? -quotient : quotient;
    }
}
// @lc code=end
