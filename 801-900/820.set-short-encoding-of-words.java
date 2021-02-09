import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=820 lang=java
 *
 * [820] Short Encoding of Words
 */

// @lc code=start
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> codes = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                codes.remove(word.substring(i));
            }
        }

        int len = 0;
        for (String code : codes) {
            len += 1 + code.length();
        }

        return len;
    }
}
// @lc code=end

