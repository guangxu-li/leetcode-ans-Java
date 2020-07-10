/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();

        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
// @lc code=end

