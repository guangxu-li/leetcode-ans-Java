/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int bound = Math.min(m - 1, n - 1);
        int dividend = 1;
        int divisor = 1;

        for (int i = 0; i < bound; i++) {

            // Overflow if dividend is too large
            dividend *= m + n - 2 - i;
            divisor *= bound - i;
        }

        return dividend / divisor;
    }
}
// @lc code=end

