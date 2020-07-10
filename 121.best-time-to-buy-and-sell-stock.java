/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int cur = 0;
        int max = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            cur = Math.max(prices[i], cur);
            max = Math.max(max, cur - prices[i]);
        }

        return max;
    }
}
// @lc code=end

