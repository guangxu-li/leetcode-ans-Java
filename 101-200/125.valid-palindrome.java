/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (int lo = 0, hi = s.length() - 1; lo <= hi; lo++, hi--) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
        }

        return true;
        /* int lo = 0;
        int hi = s.length() - 1;
        
        while (lo <= hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
                continue;
            }
        
            if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
                return false;
            }
        
            lo++;
            hi--;
        }
        
        return true;
        */
    }
}
// @lc code=end
