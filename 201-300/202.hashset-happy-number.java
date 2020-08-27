import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    private int squareOfDigit(int n) {
        int res = 0;

        while (n > 0) {
            int rem = n % 10;
            res += rem * rem;
            n /= 10;
        }

        return res;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            if (n == 1) {
                return true;
            }

            set.add(n);
            n = squareOfDigit(n);
        }

        return false;

    }
}
// @lc code=end

