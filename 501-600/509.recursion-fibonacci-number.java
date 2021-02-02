/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }
}
// @lc code=end

