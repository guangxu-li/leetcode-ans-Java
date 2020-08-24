/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    private int[] coins;
    private Integer[][] cache;

    private int dfs(int amount, int pos) {
        if (cache[amount][pos] != null) {
            return cache[amount][pos];
        }
        int count = 0;

        if (amount == 0) {
            count = 1;
        } else if (pos != coins.length) {
            int vals = 0;
            while (vals <= amount) {
                count += dfs(amount - vals, pos + 1);
                vals += coins[pos];
            }
        }

        cache[amount][pos] = count;
        return count;
    }

    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.cache = new Integer[amount + 1][coins.length + 1];

        return dfs(amount, 0);
    }
}
// @lc code=end

