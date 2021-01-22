/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int max = 0;
        int cnt = 0;

        for (char c : tasks) {
            if (max < ++counts[c - 'A']) {
                max = counts[c - 'A'];
                cnt = 1;
            } else if (max == counts[c - 'A']) {
                cnt++;
            }
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + cnt);
    }
}
// @lc code=end

