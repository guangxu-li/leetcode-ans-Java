/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            n /= 5;
            cnt += n;
        }

        return cnt;
    }
}
// @lc code=end

