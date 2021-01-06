/*
 * @lc app=leetcode id=233 lang=java
 *
 * [233] Number of Digit One
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divisor = i * 10;
            count += (n / divisor) * i + Math.min(Math.max(n % divisor - i + 1, 0L), i);
        }

        return count;
    }
}
// @lc code=end

