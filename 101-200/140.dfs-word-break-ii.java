import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    private List<String> words;
    private Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();

    private List<String> dfs(String s, int pos) {
        List<String> strs = new ArrayList<String>();

        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }

        if (pos == s.length()) {
            strs.add("");
        } else {
            for (String word : words) {
                if (s.startsWith(word, pos)) {
                    StringBuilder strBuilder = new StringBuilder(word);
                    if (pos + word.length() != s.length()) {
                        strBuilder.append(" ");
                    }

                    for (String str : dfs(s, pos + word.length())) {
                        StringBuilder tmp = new StringBuilder(strBuilder);
                        tmp.append(str);
                        strs.add(tmp.toString());
                    }
                }
            }
        }

        cache.put(pos, strs);
        return strs;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.words = wordDict;

        return dfs(s, 0);
    }
}
// @lc code=end

