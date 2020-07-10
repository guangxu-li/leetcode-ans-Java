/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int count = intervals.length; /* length of output array */

        for (int i = 0; i < intervals.length - 1; i++) {
            int[] currIntervals = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                int[] nextIntervals = intervals[j];

                if (overlap(currIntervals, nextIntervals)) {
                    intervals[j][0] = Math.min(currIntervals[0], nextIntervals[0]);
                    intervals[j][1] = Math.max(currIntervals[1], nextIntervals[1]);

                    intervals[i][0] = 0;
                    intervals[i][1] = -1;
                    count--;
                    break;
                }
            }
        }

        int[][] ans = new int[count][];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i][1]) {
                ans[--count] = intervals[i];
            }
        }

        return ans;
    }

    private boolean overlap(int[] a, int[] b) {
        return a[0] <= b[1] && a[1] >= b[0];
    }
}
// @lc code=end

