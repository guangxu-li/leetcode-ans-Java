import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    private Set<Integer> squares = new HashSet<>();

    private boolean isValid(int n, int steps) {
        if (steps == 1) {
            return squares.contains(n);
        }

        for (int square : squares) {
            if (n > square && isValid(n - square, steps - 1)) {
                return true;
            }
        }

        return false;
    }

    public int numSquares(int n) {
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        // 1 <= n <= 10 ^ 4
        for (int i = 1; i <= n; i++) {
            if (isValid(n, i)) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

