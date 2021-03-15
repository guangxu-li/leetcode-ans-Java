/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = 2 * s.length() + 3;
        char[] cs = new char[len];
        cs[0] = '@';
        cs[1] = '#';
        cs[len - 1] = '!';
        for (int i = 0; i < s.length(); i++) {
            int j = 2 + i * 2;
            cs[j] = s.charAt(i);
            cs[j + 1] = '#';
        }

        int center = 0;
        int[] radius = new int[len];
        int maxRight = 0;
        int lo = 0;
        int hi = 0;

        for (int i = 1; i < len - 1; i++) {
            if (i < maxRight) {
                radius[i] = Math.min(radius[2 * center - i], maxRight - i);
            }

            while (cs[i + radius[i] + 1] == cs[i - radius[i] - 1]) {
                radius[i]++;
            }

            if (i + radius[i] > maxRight) {
                center = i;
                maxRight = i + radius[i];
            }

            if (radius[i] > hi - lo) {
                lo = (i - radius[i] - 1) / 2;
                hi = lo + radius[i];
            }
        }

        return s.substring(lo, hi);
    }
}
// @lc code=end

