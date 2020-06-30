/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        return Math.max(traverse(s, 1), traverse(s, -1));
    }

    public int traverse(String s, int op) {
        int i = op == 1 ? 0 : s.length() - 1;
        int end = s.length() - 1 - i;

        int ans = 0;
        int l = 0;
        int r = 0;

        while ((end - i) * op >= 0) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                ans = Math.max(ans, Math.min(l, r) * 2);
            } else if ((l - r) * op < 0) {
                l = 0;
                r = 0;
            }

            i += op;
        }

        return ans;
    }
}
// @lc code=end
