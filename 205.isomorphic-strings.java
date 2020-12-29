/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sd = new char[256];
        char[] td = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (sd[sc] == 0 && td[tc] == 0) {
                sd[sc] = tc;
                td[tc] = sc;
            } else if (sd[sc] != tc || td[tc] != sc) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

