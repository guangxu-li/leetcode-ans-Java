import java.util.Arrays;

/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // could use binary search
            int j = i + 1;
            while (j < n && jobs[i][1] > jobs[j][0]) {
                j++;
            }

            dp[i] = Math.max(dp[i + 1], jobs[i][2] + dp[j]);
        }

        return dp[0];
    }
}
// @lc code=end

