import java.util.ArrayList;
import java.util.List;

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

        List<Integer> doubles = new ArrayList<>();
        List<Integer> pows = new ArrayList<>();

        int pow = -1;
        pows.add(pow);

        int value = divisor;
        doubles.add(divisor);

        while (value >= HALF_INT_MIN && value + value >= dividend) {
            value += value;
            doubles.add(value);

            pow += pow;
            pows.add(pow);
        }

        int quotient = 0;

        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (dividend <= doubles.get(i)) {
                quotient += pows.get(i);
                dividend -= doubles.get(i);
            }
        }

        return op == -1 ? -quotient : quotient;
    }
}
// @lc code=end
