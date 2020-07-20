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
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<String>();
        sentences.add("");
        Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();
        cache.put(s.length(), sentences);

        for (int i = s.length() - 1; i >= 0; i--) {
            List<String> strs = new ArrayList<String>();

            for (String word : wordDict) {
                if (s.startsWith(word, i)) {
                    for (String sentence : cache.get(i + word.length())) {
                        StringBuilder strBuilder = new StringBuilder(word);
                        if (i + word.length() != s.length()) {
                            strBuilder.append(" ");
                        }

                        strBuilder.append(sentence);
                        strs.add(strBuilder.toString());
                    }
                }
            }

            cache.put(i, strs);
        }

        return cache.get(0);
    }
}
// @lc code=end

