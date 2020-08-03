/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    private int[] coins;
    private int[] cache;

    private int dfs(int amount) {
        if (cache[amount] != 0) {
            return cache[amount];
        }

        int num = -1;
        if (amount == 0) {
            num = 0;
        } else {
            for (int coin : coins) {
                int next = -1;
                if (amount >= coin) {
                    next = dfs(amount - coin);
                }

                if (next != -1) {
                    num = num == -1 ? 1 + next : Math.min(num, 1 + next);
                }
            }
        }

        cache[amount] = num;
        return num;
    }

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.cache = new int[amount + 1];

        return dfs(amount);
    }
}
// @lc code=end

