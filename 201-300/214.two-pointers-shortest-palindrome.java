/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;

        while (hi >= 0) {
            if (s.charAt(lo) == s.charAt(hi--)) {
                lo++;
            }
        }

        if (lo == s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s.substring(lo));
        StringBuilder stringBuilder = new StringBuilder(sb);

        return sb.reverse().append(shortestPalindrome(s.substring(0, lo))).append(stringBuilder).toString();
    }
}
// @lc code=end

