/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[2][p.length() + 1];

        int currRow = 0;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length(); j >= 0; j--) {
                if (j == p.length()) {
                    dp[currRow][j] = i == s.length();
                    continue;
                }

                boolean firstMatch = i != s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[currRow][j] = dp[currRow][j + 2] || (firstMatch && dp[1 - currRow][j]);
                } else {
                    dp[currRow][j] = firstMatch && dp[1 - currRow][j + 1];
                }
            }

            currRow = 1 - currRow;
        }

        return dp[1 - currRow][0];
    }
}
// @lc code=end
