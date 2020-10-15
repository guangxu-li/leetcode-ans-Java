/*
 * @lc app=leetcode id=161 lang=java
 *
 * [161] One Edit Distance
 */

// @lc code=start
class Solution {
    private boolean substringEquals(String s, int i, String t, int j) {
        for (; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s);
        }

        if (s.length() - t.length() > 1) {
            return false;
        }

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return substringEquals(s, i + 1, t, i + 1);
                } else {
                    return substringEquals(s, i + 1, t, i);
                }
            }
        }

        return t.length() + 1 == s.length();
    }
}
// @lc code=end

