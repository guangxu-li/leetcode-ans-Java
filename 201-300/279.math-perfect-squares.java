/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        
        return n == sqrt * sqrt;
    }

    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }

        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }

        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }
}
// @lc code=end

