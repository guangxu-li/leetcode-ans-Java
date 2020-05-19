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

        for (int i = 0, j = 0; j < s.length();) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
                continue;
            }

            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        }

        return max;
    }
}
// @lc code=end
