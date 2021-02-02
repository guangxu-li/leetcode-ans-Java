/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int one = 0;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = one + two;
            one = two;
            two = tmp;
        }

        return two;
    }
}
// @lc code=end

