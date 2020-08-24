/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;

        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;

        for (char cmd : instructions.toCharArray()) {
            if (cmd == 'G') {
                x += dirs[i][0];
                y += dirs[i][1];
            } else {
                i = (dirs.length + i + (cmd == 'R' ? 1 : -1)) % dirs.length;
            }
        }

        return x == 0 && y == 0 || i != 0;
    }
}
// @lc code=end

