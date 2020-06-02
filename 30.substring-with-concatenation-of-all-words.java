import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() < words[0].length() * words.length) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int window = wordLen * words.length;

        for (int i = 0; i < wordLen; i++) {
            int start = i;

            while (start + window <= s.length()) {
                String str = s.substring(start, start + window);

                Map<String, Integer> seen = new HashMap<>();

                int j = 0;
                for (j = words.length; j > 0; j--) {
                    String word = str.substring(wordLen * (j - 1), wordLen * j);

                    int count = seen.getOrDefault(word, 0) + 1;

                    if (count > map.getOrDefault(word, 0)) {
                        break;
                    }

                    seen.put(word, count);
                }

                if (j == 0) {
                    ans.add(start);
                }

                start += wordLen * Math.max(j, 1);
            }
        }
        return ans;
    }
}
// @lc code=end
