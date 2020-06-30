/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int l = (int) Math.exp(Math.log(x) / 2);
        int r = l + 1;

        return (long) r * r > x ? l : r;
    }
}
// @lc code=end

