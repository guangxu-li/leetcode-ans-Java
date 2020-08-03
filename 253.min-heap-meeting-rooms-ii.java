import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Queue<Integer> roomsEndTime = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] interval : intervals) {
            if (!roomsEndTime.isEmpty() && interval[0] >= roomsEndTime.peek()) {
                roomsEndTime.poll();
            }

            roomsEndTime.add(interval[1]);
        }

        return roomsEndTime.size();
    }
}
// @lc code=end

