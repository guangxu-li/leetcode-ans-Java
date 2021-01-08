/*
 * @lc app=leetcode id=256 lang=java
 *
 * [256] Paint House
 */

// @lc code=start
class Solution {
    private int[][] costs;
    private Integer[][] cache;

    private int helper(int pos, int painted) {
        if (cache[pos][painted] != null) {
            return cache[pos][painted];
        }

        int min = Integer.MAX_VALUE;

        if (pos == costs.length) {
            min = 0;
        } else {
            for (int i = 0; i < 3; i++) {
                if (i == painted) {
                    continue;
                }

                min = Math.min(min, costs[pos][i] + helper(pos + 1, i));
            }
        }

        cache[pos][painted] = min;
        return min;
    }

    public int minCost(int[][] costs) {
        this.costs = costs;
        this.cache = new Integer[costs.length + 1][4];

        return helper(0, 3);
    }
}
// @lc code=end

