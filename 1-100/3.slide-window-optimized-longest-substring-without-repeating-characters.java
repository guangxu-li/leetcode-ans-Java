/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[256];
        int max = 0;

        for (int start = 0, end = 0; end < s.length(); end++) {
            start = Math.max(start, window[s.charAt(end)]);
            window[s.charAt(end)] = end + 1;

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
// @lc code=end
