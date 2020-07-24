/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int balance = 0;

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                open++;
                balance++;
            } else if (cs[i] == ')') {
                if (balance == 0) {
                    cs[i] = ' ';
                    continue;
                } else {
                    balance--;
                }
            }
        }

        // StringBuilder sb = new StringBuilder();
        open -= balance;
        int p = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                continue;
            }

            if (cs[i] == '(' && open == 0) {
                continue;

            }

            if (cs[i] == '(') {
                open--;
            }

            cs[p++] = cs[i];
            // sb.append(cs[i]);
        }

        // return sb.toString();
        return String.valueOf(cs, 0, p);
    }
}
// @lc code=end

