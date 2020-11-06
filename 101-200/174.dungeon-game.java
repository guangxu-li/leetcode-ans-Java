import java.util.Arrays;

/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[] health = new int[m + 1];
        Arrays.fill(health, Integer.MAX_VALUE);
        health[health.length - 2] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int needed = Math.min(health[j + 1], health[j]) - dungeon[i][j];
                health[j] = needed <= 0 ? 1 : needed;
            }
        }

        return health[0];
    }
}
// @lc code=end

