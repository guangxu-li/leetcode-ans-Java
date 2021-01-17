/*
 * @lc app=leetcode id=296 lang=java
 *
 * [296] Best Meeting Point
 */

// @lc code=start
class Solution {
    private int totalDistance(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        int distance = 0;

        while (lo < hi) {
            if (nums[lo] == 0) {
                lo++;
            } else if (nums[hi] == 0) {
                hi--;
            } else {
                distance += hi - lo;
                nums[hi]--;
                nums[lo]--;
            }
        }

        return distance;
    }

    /*
     * The total distance is minimum when total x distance is minimum and the total y distance
     * is minimum.
     * 
     * In 1D view, the total distance is minimum when the point split nodes into two parts
     * consisting of equal number of nodes
     * 
     * The total distance to such a point is similar to gussian formula calculation method
     */
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        return totalDistance(rows) + totalDistance(cols);
    }
}
// @lc code=end

