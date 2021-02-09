import java.util.Arrays;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        Arrays.fill(dp[n - 1], true);

        for (int pos = n - 1; pos >= 0; pos--) {
            for (int next = pos + 1; next < n; next++) {
                int step = stones[next] - stones[pos];

                if (step > pos + 1) {
                    break;
                }

                dp[pos][step] = dp[next][Math.max(0, step - 1)] || dp[next][step]
                        || dp[next][Math.min(n - 1, step + 1)];
            }
        }

        return dp[0][1];
    }
}
// @lc code=end

