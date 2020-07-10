/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        int[] dp = new int[word2.length() + 1];

        for (int i = 0; i <= word1Chars.length; i++) {
            int prev = dp[0];
            for (int j = 0; j <= word2Chars.length; j++) {
                int curr = dp[j];

                if (i == 0) {
                    dp[j] = j;
                } else if (j == 0) {
                    dp[j] = i;
                } else if (word1Chars[i - 1] != word2Chars[j - 1]) {
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                } else {
                    dp[j] = prev;
                }

                prev = curr;
            }
        }

        return dp[word2.length()];
    }
}
// @lc code=end

