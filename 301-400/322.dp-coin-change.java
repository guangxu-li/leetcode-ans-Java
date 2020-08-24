/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    dp[i] = dp[i] == -1 ? 1 + dp[i - coin] : Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount];
    }
}
// @lc code=end

