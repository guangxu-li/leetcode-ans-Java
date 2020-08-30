import java.util.ArrayList;
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
    private List<Interval> intersect(List<Interval> a, List<Interval> b) {
        List<Interval> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            int lo = Math.max(a.get(i).start, b.get(j).start);
            int hi = Math.min(a.get(i).end, b.get(j).end);

            if (lo <= hi) {
                res.add(new Interval(lo, hi));
            }

            if (a.get(i).end < b.get(j).end) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<List<Interval>> freeTime = new ArrayList<>();

        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> s = schedule.get(i);
            List<Interval> slots = new ArrayList<>();

            slots.add(new Interval(-1, s.get(0).start));
            for (int j = 0; j < s.size() - 1; j++) {
                slots.add(new Interval(s.get(j).end, s.get(j + 1).start));
            }
            slots.add(new Interval(s.get(s.size() - 1).end, Integer.MAX_VALUE));

            freeTime.add(slots);
        }

        List<Interval> intervals = freeTime.get(0);
        for (int i = 1; i < schedule.size(); i++) {
            intervals = intersect(intervals, freeTime.get(i));
        }

        if (intervals.get(0).start == -1) {
            intervals.remove(0);
        }

        if (intervals.get(intervals.size() - 1).end == Integer.MAX_VALUE) {
            intervals.remove(intervals.size() - 1);
        }

        return intervals;
    }
}
// @lc code=end

