import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=1353 lang=java
 *
 * [1353] Maximum Number of Events That Can Be Attended
 */

// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        Queue<Integer> current = new PriorityQueue<>();

        int n = events.length;
        int day = 0;
        int i = 0;
        int cnt = 0;

        while (i < n || !current.isEmpty()) {
            if (current.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] == day) {
                current.add(events[i++][1]);
            }

            current.poll();
            cnt++;
            day++;

            while (!current.isEmpty() && day > current.peek()) {
                current.poll();
            }
        }

        return cnt;
    }
}
// @lc code=end

