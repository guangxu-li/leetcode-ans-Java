import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    private int[] smallessSkipLoss(int[] prices, List<int[]> trans) {
        int minIdx = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < trans.size(); i++) {
            int loss = prices[trans.get(i)[1]] - prices[trans.get(i)[0]];

            if (loss < min) {
                minIdx = i;
                min = loss;
            }
        }

        return new int[] {minIdx, min};
    }

    private int[] smallestMeregeLoss(int[] prices, List<int[]> trans) {
        int minIdx = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < trans.size(); i++) {
            int loss = prices[trans.get(i - 1)[1]] - prices[trans.get(i)[0]];

            if (loss < min) {
                minIdx = i;
                min = loss;
            }
        }

        return new int[] {minIdx, min};
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        List<int[]> trans = new ArrayList<>();
        for (int i = 1, lo = 0, hi = 0; i <= prices.length; i++) {
            if (i < prices.length && prices[i] >= prices[i - 1]) {
                hi = i;
            } else {
                if (hi > lo) {
                    trans.add(new int[] {lo, hi});
                }

                lo = i;
            }
        }

        while (trans.size() > k) {
            int[] skip = smallessSkipLoss(prices, trans);
            int[] merge = smallestMeregeLoss(prices, trans);

            if (skip[1] <= merge[1]) {
                trans.remove(skip[0]);
            } else {
                trans.get(merge[0] - 1)[1] = trans.get(merge[0])[1];
                trans.remove(merge[0]);
            }
        }

        int profit = 0;
        for (int[] tran : trans) {
            profit += prices[tran[1]] - prices[tran[0]];
        }

        return profit;
    }
}
// @lc code=end
