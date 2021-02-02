/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] cnts = new int[26];
        char[] cs = s.toCharArray();

        for (char c : cs) {
            cnts[c - 'a']++;
        }

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (cnts[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

