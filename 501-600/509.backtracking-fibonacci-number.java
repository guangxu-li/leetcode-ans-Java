/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    private int[] memo;

    private int helper(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = n <= 1 ? n : helper(n - 1) + helper(n - 2);

        return memo[n];
    }

    public int fib(int n) {
       this.memo = new int[n + 1]; 

       return helper(n);
    }
}
// @lc code=end

