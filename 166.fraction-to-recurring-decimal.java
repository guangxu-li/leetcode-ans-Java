import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder fraction = new StringBuilder();

        // Only one of them is negative
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator); // Convert to long to avoid abs() overflow

        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;

        if (remainder > 0) {
            fraction.append(".");
        }

        Map<Long, Integer> rems = new HashMap<>();
        while (remainder > 0) {
            if (rems.containsKey(remainder)) {
                fraction.insert(rems.get(remainder), "(");
                fraction.append(")");

                break;
            }

            rems.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }

        return fraction.toString();
    }
}
// @lc code=end
