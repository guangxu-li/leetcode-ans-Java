/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int lo = findStart(intervals, newInterval[0]);
        if (lo != intervals.length) {
            newInterval[0] = Math.min(intervals[lo][0], newInterval[0]);
        }

        int hi = findEnd(intervals, lo, newInterval[1]);
        if (hi != 0) {
            newInterval[1] = Math.max(intervals[hi - 1][1], newInterval[1]);
        }

        int num = intervals.length + (lo > hi - 1 ? 1 : lo - hi + 1);
        int[][] ans = new int[num][];

        num = 0;
        for (int i = 0; i < lo; i++) {
            ans[num++] = intervals[i];
        }

        ans[num++] = newInterval;

        for (int i = hi; i < intervals.length; i++) {
            ans[num++] = intervals[i];
        }

        return ans;
    }

    private int findStart(int[][] intervals, int target) {
        int lo = 0;
        int hi = intervals.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (intervals[mid][1] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private int findEnd(int[][] intervals, int i, int target) {
        int lo = i;
        int hi = intervals.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (intervals[mid][0] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
// @lc code=end

