/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    private StringBuilder removeInvalidParentheses(String s, char open, char close) {
        StringBuilder sb = new StringBuilder();

        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == open) {
                balance++;
            } else if (s.charAt(i) == close) {
                if (balance == 0) {
                    continue;
                }

                balance--;
            }

            sb.append(s.charAt(i));
        }

        return sb;
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder validSB = removeInvalidParentheses(s, '(', ')');
        validSB = removeInvalidParentheses(validSB.reverse().toString(), ')', '(');

        return validSB.reverse().toString();
    }
}
// @lc code=end

