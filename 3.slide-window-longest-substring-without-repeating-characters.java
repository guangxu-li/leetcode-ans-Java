import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;

        int lo = 0;
        int hi = 0;

        while (hi < s.length()) {
            if (!set.contains(s.charAt(hi))) {
                set.add(s.charAt(hi++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(lo++));
            }
        }

        return max;
    }
}
// @lc code=end
