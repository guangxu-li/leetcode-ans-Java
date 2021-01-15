import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(c) && !map1.get(c).equals(word)) {
                return false;
            }

            if (map2.containsKey(word) && map2.get(word) != c) {
                return false;
            }

            map1.put(c, word);
            map2.put(word, c);
        }

        return true;
    }
}
// @lc code=end

