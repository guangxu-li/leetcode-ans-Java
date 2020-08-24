/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    private int[] coins;
    private Integer[][] cache;

    private int dfs(int pos, int amount) {
        if (cache[pos][amount] != null) {
            return cache[pos][amount];
        }

        int count = 0;

        if (amount == 0) {
            return 1;
        } else if (pos < coins.length) {
            if (coins[pos] <= amount) {
                count = dfs(pos, amount + coins[pos]);
            }

            count += dfs(pos + 1, amount);
        }

        cache[pos][amount] = count;
        return count;

    }

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.cache = new Integer[coins.length + 1][amount + 1];

        return dfs(0, amount);
    }
}
// @lc code=end

