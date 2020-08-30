import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=759 lang=java
 *
 * [759] Employee Free Time
 */

// @lc code=start
/*
 * // Definition for an Interval. class Interval { public int start; public int end;
 * 
 * public Interval() {}
 * 
 * public Interval(int _start, int _end) { start = _start; end = _end; } };
 */

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<int[]> events = new ArrayList<>();
        for (List<Interval> l : schedule) {
            for (Interval i : l) {
                events.add(new int[] {i.start, 1});
                events.add(new int[] {i.end, -1});
            }
        }
        Collections.sort(events, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<Interval> freeTime = new ArrayList<>();

        int prev = -1;
        int balance = 0;

        for (int[] event : events) {
            if (prev > 0 && balance == 0) {
                freeTime.add(new Interval(prev, event[0]));
            }

            balance += event[1];
            prev = event[0];
        }


        return freeTime;
    }
}
// @lc code=end

