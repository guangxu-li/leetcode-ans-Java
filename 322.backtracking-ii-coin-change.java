import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    private int min = -1;
    private int[] coins;

    private void dfs(int amount, int count, int pos) {
        if (pos < 0) {
            return;
        }

        if (amount % coins[pos] == 0) {
            min = min == -1 ? count + amount / coins[pos]
                    : Math.min(min, count + amount / coins[pos]);
        } else {
            for (int i = amount / coins[pos]; i >= 0; i--) {
                if (min != -1 && count + i >= min) {
                    return;
                }

                dfs(amount - i * coins[pos], count + i, pos - 1);
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;

        Arrays.sort(coins);

        dfs(amount, 0, coins.length - 1);

        return min;
    }
}
// @lc code=end

