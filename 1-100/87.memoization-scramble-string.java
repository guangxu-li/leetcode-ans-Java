/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    private int[][][] dp;

    public boolean isScramble(String s1, String s2) {
        dp = new int[s1.length()][s1.length()][s1.length()];

        if (s1.length() != s2.length()) {
            return false;
        }

        return helper(s1.toCharArray(), 0, s2.toCharArray(), 0, s1.length());
    }

    private boolean helper(char[] s1, int lo1, char[] s2, int lo2, int len) {
        if (dp[len - 1][lo1][lo2] != 0) {
            return dp[len - 1][lo1][lo2] == 1;
        }

        boolean isScramble = false;
        if (len == 1) {
            isScramble = s1[lo1] == s2[lo2];
        } else {
            int leftAndLeft = 0;
            int leftAndRight = 0;

            for (int i = 1; i < len; i++) {
                leftAndLeft ^= 1 << (s1[lo1 + i - 1] - 'a');
                leftAndLeft ^= 1 << (s2[lo2 + i - 1] - 'a');
                if (leftAndLeft == 0 && helper(s1, lo1, s2, lo2, i)
                        && helper(s1, lo1 + i, s2, lo2 + i, len - i)) {
                    isScramble = true;
                    break;
                }

                leftAndRight ^= (1 << (s1[lo1 + i - 1] - 'a'));
                leftAndRight ^= (1 << (s2[lo2 + len - i] - 'a'));
                if (leftAndRight == 0 && helper(s1, lo1, s2, lo2 + len - i, i)
                        && helper(s1, lo1 + i, s2, lo2, len - i)) {
                    isScramble = true;
                    break;
                }
            }
        }

        dp[len - 1][lo1][lo2] = isScramble ? 1 : -1;
        return isScramble;
    }
}
// @lc code=end

