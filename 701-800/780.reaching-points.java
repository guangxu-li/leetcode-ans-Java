/*
 * @lc app=leetcode id=780 lang=java
 *
 * [780] Reaching Points
 */

// @lc code=start
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx < ty) {
                if (tx == sx) {
                    return (ty - sy) % tx == 0;
                } else {
                    ty %= tx;
                }
            } else if (tx == ty) {
                break;
            } else {
                if (ty == sy) {
                    return (tx - sx) % ty == 0;
                } else {
                    tx %= ty;
                }
            }
        }

        return sx == ty && sy == ty;
    }
}
// @lc code=end

