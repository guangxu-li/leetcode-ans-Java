/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int trans1Cost = Integer.MAX_VALUE;
        int trans1Profit = 0;
        int trans2Cost = Integer.MAX_VALUE;
        int trans2Profit = 0;

        for (int price : prices) {
            trans1Cost = Math.min(trans1Cost, price);
            trans1Profit = Math.max(trans1Profit, price - trans1Cost);
            trans2Cost = Math.min(trans2Cost, price - trans1Profit);
            trans2Profit = Math.max(trans2Profit, price - trans2Cost);
        }

        return trans2Profit;
    }
}
// @lc code=end

