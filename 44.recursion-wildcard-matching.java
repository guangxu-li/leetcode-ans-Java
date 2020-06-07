/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    enum Result {
        TRUE, FALSE;
    }

    private Result[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Result[s.length() + 1][p.length() + 1];

        return helper(s, 0, removeDuplicatedStars(p), 0);
    }

    public String removeDuplicatedStars(String p) {
        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < p.length()) {
            ans.append(p.charAt(i));

            int j = i + 1;
            if (p.charAt(i) == '*') {
                while (j < p.length() && p.charAt(j) == '*') {
                    j++;
                }
            }

            i = j;
        }

        return ans.toString();
    }

    public boolean helper(String s, int i, String p, int j) {
        if (dp[i][j] != null) {
            return dp[i][j] == Result.TRUE;
        }

        boolean ans = false;

        if (j == p.length()) {
            ans = i == s.length();
        } else if (i == s.length()) {
            ans = p.charAt(j) == '*' && helper(s, i, p, j + 1);
        } else if (p.charAt(j) == '*') {
            ans = helper(s, i + 1, p, j) || helper(s, i, p, j + 1);
        } else if (p.charAt(j) == '?') {
            ans = helper(s, i + 1, p, j + 1);
        } else {
            ans = s.charAt(i) == p.charAt(j) && helper(s, i + 1, p, j + 1);
        }

        dp[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
// @lc code=end

