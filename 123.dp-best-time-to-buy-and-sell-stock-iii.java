/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] maxRight = new int[prices.length + 1];
        int[] maxLeft = new int[prices.length + 1];

        for (int i = 0, min = Integer.MAX_VALUE, max = 0; i < prices.length; i++) {
            int l = i;
            int r = prices.length - i - 1;

            min = Math.min(min, prices[l]);
            max = Math.max(max, prices[r]);
            maxLeft[l + 1] = Math.max(maxLeft[l], prices[l] - min);
            maxRight[r] = Math.max(maxRight[r + 1], max - prices[r]);

        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, maxLeft[i + 1] + maxRight[i + 1]);
        }

        return profit;
    }
}
// @lc code=end

