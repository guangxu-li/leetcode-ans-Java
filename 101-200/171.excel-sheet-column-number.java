/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        return s.isEmpty() ? 0
                : s.charAt(s.length() - 1) - 'A' + 1
                        + 26 * titleToNumber(s.substring(0, s.length() - 1));
    }
}
// @lc code=end

