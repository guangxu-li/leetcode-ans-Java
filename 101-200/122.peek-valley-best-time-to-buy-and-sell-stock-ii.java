/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0, buy = 0, sell = 0; i < prices.length - 1; i++) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sell = prices[i];

            profit += sell - buy;
        }

        return profit;
    }
}
// @lc code=end

