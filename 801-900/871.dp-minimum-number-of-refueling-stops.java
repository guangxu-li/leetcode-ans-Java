/*
 * @lc app=leetcode id=871 lang=java
 *
 * [871] Minimum Number of Refueling Stops
 */

// @lc code=start
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel; // dp[i] -> fuel after i stops

        // i -> add i stations
        for (int i = 1; i <= n; i++) {
            // update dp[] after one more new station available
            for (int j = i; j >= 1 && dp[j - 1] >= stations[i - 1][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + (long) stations[i - 1][1]);
            }
        }

        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

