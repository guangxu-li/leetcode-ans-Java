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
        
        
        Map idxs = new HashMap();

        // int i doesn't work for line +10
        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            idxs.putIfAbsent(c, i);
            idxs.putIfAbsent(word, i);

            /* if used int but not Integer, then even though values are the same but the condition
             is false */
            if (idxs.get(c) != idxs.get(word)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

