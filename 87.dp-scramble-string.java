/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int length = s1.length();

        // dp[len - 1][i][j] => if s1(i, ..., i + len) and s2(j, ..., j + len) is scramble
        boolean[][][] dp = new boolean[length + 1][length][length];

        for (int len = 1; len <= length; len++) {
            for (int i = 0; i + len <= length; i++) {
                for (int j = 0; j + len <= length; j++) {
                    if (len == 1) {
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int pivot = 1; pivot < len && !dp[len][i][j]; pivot++) {
                            dp[len][i][j] =
                                    (dp[pivot][i][j] && dp[len - pivot][i + pivot][j + pivot])
                                            || (dp[pivot][i][j + len - pivot]
                                                    && dp[len - pivot][i + pivot][j]);
                        }
                    }
                }
            }
        }

        return dp[length][0][0];
    }
}
// @lc code=end

