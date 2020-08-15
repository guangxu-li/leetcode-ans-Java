import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    private Set<String> strs = new HashSet<>();

    private void dfs(char[] cs, int pos, int l, int r, int balance, StringBuilder sb) {
        if (pos == cs.length) {
            if (l == 0 && r == 0) {
                strs.add(sb.toString());
            }
        } else {
            if (l < 0 || r < 0 || balance < 0) {
                return;
            } else {
                if (cs[pos] != '(' && cs[pos] != ')') {
                    sb.append(cs[pos]);
                    dfs(cs, pos + 1, l, r, balance, sb);
                    sb.deleteCharAt(sb.length() - 1);
                } else if (cs[pos] == '(') {
                    dfs(cs, pos + 1, l - 1, r, balance, sb);

                    sb.append(cs[pos]);
                    dfs(cs, pos + 1, l, r, balance + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    dfs(cs, pos + 1, l, r - 1, balance, sb);

                    sb.append(cs[pos]);
                    dfs(cs, pos + 1, l, r, balance - 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;

        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }

        dfs(cs, 0, l, r, 0, new StringBuilder());

        return new ArrayList<>(strs);
    }
}
// @lc code=end

