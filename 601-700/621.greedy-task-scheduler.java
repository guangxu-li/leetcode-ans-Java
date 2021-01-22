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

        for (char c : tasks) {
            max = Math.max(max, ++counts[c - 'A']);
        }

        int idle = (max - 1) * n;
        for (int i = 0, flag = 0; i < 26; i++) {
            if (counts[i] == max && flag == 0) {
                flag = 1;
            } else {
                idle -= Math.min(max - 1, counts[i]);
            }
        }

        return Math.max(0, idle) + tasks.length;
    }
}
// @lc code=end

