/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;

        for (int i = s.length() - 1; i >= 0 && (s.charAt(i) != ' ' || ans == 0); i--) {
            if (s.charAt(i) != ' ') {
                ans++;
            }
        }

        return ans;
    }
}
// @lc code=end

