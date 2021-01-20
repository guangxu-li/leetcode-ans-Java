import java.util.Arrays;

/*
 * @lc app=leetcode id=1335 lang=java
 *
 * [1335] Minimum Difficulty of a Job Schedule
 */

// @lc code=start
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        for (int remDay = 1; remDay <= d; remDay++) {
            for (int pos = d - remDay; pos <= n - remDay; pos++) {
                dp[pos] = Integer.MAX_VALUE;
                
                int max = 0;
                for (int i = pos; i <= n - remDay; i++) {
                    max = Math.max(max, jobDifficulty[i]);

                    int cost = dp[i + 1];
                    if (cost == -1) {
                        continue;
                    }
                    
                    dp[pos] = Math.min(dp[pos], max + cost);
                }

                dp[pos] = dp[pos] == Integer.MAX_VALUE ? -1 : dp[pos];
            }
        }

        return dp[0];
    }
}
// @lc code=end

