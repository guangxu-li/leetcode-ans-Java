import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (s.startsWith(word, i) && dp[i + word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
// @lc code=end

