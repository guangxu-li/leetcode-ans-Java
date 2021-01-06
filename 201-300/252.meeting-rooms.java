import java.util.Arrays;

/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i - 1];
            int[] cur = intervals[i];

            if (prev[1] > cur[0]) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

