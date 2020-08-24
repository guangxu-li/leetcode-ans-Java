/*
 * @lc app=leetcode id=780 lang=java
 *
 * [780] Reaching Points
 */

// @lc code=start
class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }

        if ((sx == tx && sy == ty) || (sx == ty && sy == tx)) {
            return true;
        }

        return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty);
    }
}
// @lc code=end

