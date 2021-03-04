import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=465 lang=java
 *
 * [465] Optimal Account Balancing
 */

// @lc code=start
class Solution {
    private int minTrans(List<Integer> profit, int pos) {
        while (pos < profit.size() && profit.get(pos) == 0) {
            pos++;
        }

        if (pos == profit.size())
            return 0;

        int cnt = Integer.MAX_VALUE;
        int cur = profit.get(pos);
        for (int i = pos + 1; i < profit.size(); i++) {
            int next = profit.get(i);
            if ((cur > 0 && next < 0) || (cur < 0 && next > 0)) {
                profit.set(i, cur + next);
                cnt = Math.min(cnt, 1 + minTrans(profit, pos + 1));
                profit.set(i, profit.get(i) - cur);
            }
        }

        return cnt;
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> profit = new HashMap<>();
        for (int[] transaction : transactions) {
            profit.put(transaction[0], profit.getOrDefault(transaction[0], 0) - transaction[2]);
            profit.put(transaction[1], profit.getOrDefault(transaction[1], 0) + transaction[2]);
        }

        return minTrans(new ArrayList<>(profit.values()), 0);
    }
}
// @lc code=end

