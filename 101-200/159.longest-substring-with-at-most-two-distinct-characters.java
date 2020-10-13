import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int lo = 0;
        int hi = 0;

        int[] counts = new int[256];
        Set<Character> cs = new HashSet<>();

        int maxLen = 0;
        int len = 0;

        while (hi < s.length()) {
            char c = s.charAt(hi);

            if (cs.size() < 2) {
                cs.add(c);
                counts[c]++;

                hi++;
                len++;
            } else if (cs.size() == 2 && !cs.contains(c)) {
                maxLen = Math.max(maxLen, len);

                while (--counts[s.charAt(lo)] > 0) {
                    lo++;
                    len--;
                }

                cs.remove(s.charAt(lo++));
                len--;
            }
        }

        return Math.max(maxLen, len);
    }
}
// @lc code=end

