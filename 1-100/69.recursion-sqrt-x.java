/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int l = mySqrt(x >> 2) << 1;
        int r = l + 1;
        return (long) r * r > x ? l : r;
    }
}
// @lc code=end

