/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;

            // * Integer.MAX_VALUE =  2147483647
            // * Integer.MIN_VALUE = -2147483648
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10) && tmp > 7) {
                return 0;
            } else if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10) && tmp < -8) {
                return 0;
            } else {
                ans = 10 * ans + tmp;
            }
        }

        return ans;
    }
}
// @lc code=end
