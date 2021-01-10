/*
 * @lc app=leetcode id=265 lang=java
 *
 * [265] Paint House II
 */

// @lc code=start
class Solution {
    private int[] getTwoSmallest(int[] nums) {
        Integer min1 = null;
        Integer min2 = null;

        for (int num : nums) {
            if (min1 == null || num < min1) {
                min2 = min1;
                min1 = num;
            } else if (min2 == null || num < min2) {
                min2 = num;
            }
        }

        if (min2 == null) {
            min2 = min1;
        }

        return new int[] {min1, min2};
    }

    public int minCostII(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--) {
            int[] mins = getTwoSmallest(costs[i + 1]);

            for (int j = 0; j < costs[0].length; j++) {
                int min = costs[i + 1][j] == mins[0] ? mins[1] : mins[0];
                costs[i][j] += min;
            }
        }

        return costs.length == 0 ? 0 : getTwoSmallest(costs[0])[0];
    }
}
// @lc code=end

