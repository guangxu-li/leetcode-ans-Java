import java.util.Arrays;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int lo = 0;
        int hi = 0;

        int count = 0;

        while (hi < intervals.length) {
            if (startTime[hi] >= endTime[lo]) {
                lo++;
            } else {
                count++;
            }

            hi++;
        }

        return count;
    }
}
// @lc code=end

