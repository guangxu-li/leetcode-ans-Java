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

        int pow = -1;
        int value = divisor;

        while (value >= HALF_INT_MIN && value + value >= dividend) {
            value += value;
            pow += pow;
        }

        int quotient = 0;

        while (dividend <= divisor) {
            if (dividend <= value) {
                dividend -= value;
                quotient += pow;
            }

            value >>= 1;
            pow >>= 1;
        }

        return op == -1 ? -quotient : quotient;
    }
}
// @lc code=end
