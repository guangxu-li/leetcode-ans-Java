import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];

        Queue<int[]> ts = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (char c : tasks) {
            if (counts[c - 'A']++ == 0 ) {
                ts.add(new int[] {c - 'A', 0});
            }
        }


        int timer = 0;
        while (!ts.isEmpty()) {
            if (ts.peek()[1] <= timer) {
                int[] next = ts.poll();
                if (--counts[next[0]] > 0) {
                    ts.add(new int[] {next[0], next[1] + n + 1});
                }
            }

            timer++;
        }

        return timer;
    }
}
// @lc code=end

