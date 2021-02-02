/*
 * @lc app=leetcode id=573 lang=java
 *
 * [573] Squirrel Simulation
 */

// @lc code=start
class Solution {
    private int calc(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int min =  0;
        int maxDiff = Integer.MIN_VALUE;

        for (int[] nut : nuts) {
            int distance = calc(nut, tree);
            min += 2 * distance;
            maxDiff = Math.max(maxDiff, distance - calc(nut, squirrel));
        }

        return min - maxDiff;
    }
}
// @lc code=end

