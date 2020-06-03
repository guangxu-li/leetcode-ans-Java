/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                String str = s.substring(i, j);
                if (isValid(str)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    public boolean isValid(String str) {
        int balance = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}
// @lc code=end
