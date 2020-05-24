/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[256];
        char[] sChars = s.toCharArray();
        int max = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            start = Math.max(start, window[sChars[end]]);
            window[sChars[end]] = end + 1;

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
// @lc code=end
