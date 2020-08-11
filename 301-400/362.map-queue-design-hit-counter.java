import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 */

// @lc code=start
class HitCounter {
    Map<Integer, Integer> counter;
    Queue<Integer> times;
    int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        counter = new HashMap<>();
        times = new ArrayDeque<>();
        count = 0;
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        count++;
        if (!counter.containsKey(timestamp)) {
            counter.put(timestamp, 1);
            times.add(timestamp);
        } else {
            counter.put(timestamp, counter.get(timestamp) + 1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!times.isEmpty() && times.peek() <= timestamp - 300) {
            int time = times.poll();
            count -= counter.get(time);
            counter.remove(time);
        }

        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
// @lc code=end

