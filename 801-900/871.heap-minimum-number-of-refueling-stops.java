import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=871 lang=java
 *
 * [871] Minimum Number of Refueling Stops
 */

// @lc code=start
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // total gas of all stations passed by
        Queue<Integer> stock = new PriorityQueue<>(Collections.reverseOrder()); 

        int fuel = startFuel;
        int stop = 0;
        int next = 0;

        while (fuel < target) {
            while (next < stations.length && fuel >= stations[next][0]) {
                stock.add(stations[next++][1]);
            }

            if (stock.isEmpty()) {
                return -1;
            }

            fuel += stock.poll();
            stop++;
        }

        return stop;
    }
}
// @lc code=end

