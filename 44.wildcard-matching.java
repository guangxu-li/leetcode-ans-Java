/*
 * @lc app=leetcode id=44 lang=idxava
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                int idx = 0;
                while (idx <= s.length() && !dp[i - 1][idx]) {
                    idx++;
                }

                for (int j = idx; j <= s.length(); j++) {
                    dp[i][j] = true;
                }
            } else if (p.charAt(i - 1) == '?') {
                for (int j = 1; j <= s.length(); j++) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            } else {
                for (int j = 1; j <= s.length(); j++) {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}
// @lc code=end

