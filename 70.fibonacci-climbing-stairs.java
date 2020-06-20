/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int N = 0; /* final ans */

        int op1 = 1;
        int op2 = 1;
        for (int i = 2; i <= n; i++) {
            N = op1 + op2;
            op1 = op2;
            op2 = N;
        }

        return op2;
    }
}
// @lc code=end

