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

        int quotient = 0;
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

        while (dividend <= divisor) {
            int pow = -1;
            int value = divisor;

            while (value >= HALF_INT_MIN && value + value >= dividend) {
                pow += pow;
                value += value;
            }

            quotient += pow;
            dividend -= value;
        }

        return op == -1 ? -quotient : quotient;
    }
}
// @lc code=end
