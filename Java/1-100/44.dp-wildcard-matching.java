/*
 * @lc app=leetcode id=44 lang=idxava
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[2][s.length() + 1];

        int currRow = 1;
        dp[1 - currRow][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (j == 0) {
                    dp[currRow][j] = p.charAt(i - 1) == '*' && dp[1 - currRow][j];
                } else if (p.charAt(i - 1) == '*') {
                    dp[currRow][j] = dp[1 - currRow][j] || dp[currRow][j - 1];
                } else if (p.charAt(i - 1) == '?') {
                    dp[currRow][j] = dp[1 - currRow][j - 1];
                } else {
                    dp[currRow][j] = p.charAt(i - 1) == s.charAt(j - 1) && dp[1 - currRow][j - 1];
                }
            }

            currRow = 1 - currRow;
        }

        return dp[1 - currRow][s.length()];
    }
}
// @lc code=end
