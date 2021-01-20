import java.util.Arrays;

/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start
class Solution {
    private Integer[] memo;

    private boolean overlap(int[] a, int[] b) {
        return a[1] > b[0];
    }

    private int maxProfit(int[][] jobs, int pos) {
        if (memo[pos] != null) {
            return memo[pos];
        }

        int max = 0;
        if (pos < jobs.length) {
            int i = pos + 1;
            while (i < jobs.length && overlap(jobs[pos], jobs[i])) {
                i++;
            }

            max = Math.max(maxProfit(jobs, pos + 1), jobs[pos][2] + maxProfit(jobs, i));
        }

        memo[pos] = max;
        return max;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        this.memo = new Integer[profit.length + 1];

        int[][] jobs = new int[profit.length][3];
        for (int i = 0; i < profit.length - 1; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        return maxProfit(jobs, 0);
    }
}
// @lc code=end

