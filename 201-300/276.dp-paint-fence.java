/*
 * @lc app=leetcode id=276 lang=java
 *
 * [276] Paint Fence
 */

// @lc code=start
class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        int memo1 = k;
        int memo2 = k * k;

        for (int i = 3; i <= n; i++) {
            int ways = (memo1 + memo2) * (k - 1);
            memo1 = memo2;
            memo2 = ways;
        }

        return memo2;
    }
}
// @lc code=end

