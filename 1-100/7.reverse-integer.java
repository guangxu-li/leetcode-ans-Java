/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            /* Integer.MAX_VALUE =  2147483647
             * Integer.MIN_VALUE = -2147483648 */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            } else if (rev < Integer.MIN_VALUE / 10
                    || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            } else {
                rev = rev * 10 + pop;
            }
        }
        return rev;
    }
}
// @lc code=end
