/*
 * @lc app=leetcode id=276 lang=java
 *
 * [276] Paint Fence
 */

// @lc code=start
class Solution {
    private int[] memo;

    private int ways(int n, int k) {
        if (memo[n] != 0) {
            return memo[n];
        }

        int count = 0;
        if (n == 1) {
            count = k;
        } else if (n == 2) {
            count = k * k;
        } else {
            count = (ways(n - 1, k) + ways(n - 2, k)) * (k - 1);
        }

        memo[n] = count;
        return count;
    }

    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        
        this.memo = new int[n + 1];
        return ways(n, k);
    }
}
// @lc code=end

