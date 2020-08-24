/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int lo = i / 2;
            int hi = lo + i % 2;

            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                count++;
                lo--;
                hi++;
            }
        }

        return count;
    }
}
// @lc code=end

