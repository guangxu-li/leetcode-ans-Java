import java.util.Arrays;

/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public void formLink(int[] lastIdx, int[] prevIdx, char[] tChars) {
        Arrays.fill(lastIdx, -1);

        for (int i = tChars.length - 1; i >= 0; i--) {
            prevIdx[i] = lastIdx[tChars[i]];
            lastIdx[tChars[i]] = i;
        }
    }

    public int numDistinct(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] dp = new int[tChars.length + 1];
        dp[tChars.length] = 1;

        int[] lastIdx = new int[128];
        int[] prevIdx = new int[tChars.length];

        formLink(lastIdx, prevIdx, tChars);

        for (int i = sChars.length - 1; i >= 0; i--) {
            for (int j = lastIdx[sChars[i]]; j != -1; j = prevIdx[j]) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }
}
// @lc code=end

