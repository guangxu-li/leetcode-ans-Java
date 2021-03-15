/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    private int expandCenter(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }

        return hi - lo - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expandCenter(s, i, i), expandCenter(s, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = start + len;
            }
        }

        return s.substring(start, end);
    }
}
// @lc code=end

