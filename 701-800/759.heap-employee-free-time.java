import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
class Employee {
    public List<Interval> jobs;
    public int cur;

    public Employee() {
    }

    public Employee(List<Interval> jobs, int cur) {
        this.jobs = jobs;
        this.cur = cur;
    }

    public Interval peek() {
        return jobs.get(cur);
    }

    public Interval poll() {
        return jobs.get(cur++);
    }

    public boolean isEmpty() {
        return cur == jobs.size();
    }
}


class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Employee> es = new PriorityQueue<>((a, b) -> a.peek().start - b.peek().start);

        for (int i = 0; i < schedule.size(); i++) {
            es.add(new Employee(schedule.get(i), 0));
        }

        List<Interval> freeTime = new ArrayList<>();

        int anchor = 0;
        while (!es.isEmpty()) {
            Employee e = es.poll();
            Interval i = e.poll();

            if (anchor > 0 && anchor < i.start) {
                freeTime.add(new Interval(anchor, i.start));
            }

            anchor = Math.max(anchor, i.end);

            if (!e.isEmpty()) {
                es.add(e);
            }
        }

        return freeTime;
    }
}
// @lc code=end

