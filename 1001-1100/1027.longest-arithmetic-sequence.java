import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Subsequence
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        int max = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int step = A[i] - A[j];
                dp[i].put(step, 1 + dp[j].getOrDefault(step, 1));
                max = Math.max(max, dp[i].get(step));
            }
        }

        return max;
    }
}
// @lc code=end

