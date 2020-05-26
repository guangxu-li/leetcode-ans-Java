/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    enum Result {
        TRUE, FALSE
    }

    Result[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Result[s.length() + 1][p.length() + 1];
        return match(s, 0, p, 0);
    }

    public boolean match(String s, int i, String p, int j) {
        if (dp[i][j] != null) {
            return dp[i][j] == Result.TRUE;
        }

        boolean ans;

        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean firstMatch = i != s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                ans = match(s, i, p, j + 2) || (firstMatch && match(s, i + 1, p, j));
            } else {
                ans = firstMatch && match(s, i + 1, p, j + 1);
            }
        }
        dp[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
// @lc code=end
