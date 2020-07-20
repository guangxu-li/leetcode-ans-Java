import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    private List<String> words;
    private Integer[] cache;

    private boolean dfs(String s, int pos) {
        if (cache[pos] != null) {
            return cache[pos] == 1;
        }

        boolean res = false;
        if (pos == s.length()) {
            res = true;
        } else {
            for (String word : words) {
                if (s.startsWith(word, pos) && dfs(s, pos + word.length())) {
                    res = true;
                    break;
                }
            }
        }

        cache[pos] = res ? 1 : 0;
        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        words = wordDict;
        cache = new Integer[s.length() + 1];

        return dfs(s, 0);
    }
}
// @lc code=end

