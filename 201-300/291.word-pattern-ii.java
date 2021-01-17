import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=291 lang=java
 *
 * [291] Word Pattern II
 */

// @lc code=start
class Solution {
    private Map<Character, String> matches1 = new HashMap<>();
    private Set<String> matches2 = new HashSet<>();
    private char[] pattern;
    private char[] word;

    private boolean equal(String expected, int start) {
        if (word.length - start < expected.length()) {
            return false;
        }

        for (int i = 0; i < expected.length(); i++, start++) {
            if (expected.charAt(i) != word[start]) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int pIdx, int wIdx) {
        if (pIdx == pattern.length) {
            return wIdx == word.length;
        } else {
            if (matches1.containsKey(pattern[pIdx])) {
                String expected = matches1.get(pattern[pIdx]);

                return equal(expected, wIdx) && isValid(pIdx + 1, wIdx + expected.length());
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = wIdx; i <= word.length - pattern.length + pIdx; i++) {
                    if (matches2.contains(sb.append(word[i]).toString())) {
                        continue;
                    }

                    matches1.put(pattern[pIdx], sb.toString());
                    matches2.add(sb.toString());
                    if (isValid(pIdx + 1, i + 1)) {
                        return true;
                    }

                    matches2.remove(sb.toString());
                }

                matches1.remove(pattern[pIdx]);
            }
        }

        return false;
    }

    public boolean wordPatternMatch(String pattern, String s) {
        if (pattern.length() > s.length()) {
            return false;
        }

        this.pattern = pattern.toCharArray();
        this.word = s.toCharArray();

        return isValid(0, 0);
    }
}
// @lc code=end

