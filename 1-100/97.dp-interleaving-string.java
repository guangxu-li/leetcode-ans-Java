/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[] dp = new boolean[c2.length + 1];

        for (int i = 0; i <= c1.length; i++) {
            for (int j = 0; j <= c2.length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else {
                    if (i != 0) {
                        dp[j] = dp[j] && c1[i - 1] == c3[i + j - 1];
                    }

                    if (!dp[j] && j != 0) {
                        dp[j] = dp[j - 1] && c2[j - 1] == c3[i + j - 1];
                    }
                }
            }
        }

        return dp[c2.length];
    }
}
// @lc code=end

