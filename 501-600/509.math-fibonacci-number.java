/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;

        return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }
}
// @lc code=end

