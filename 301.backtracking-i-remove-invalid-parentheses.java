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
    private int min = Integer.MAX_VALUE;

    private void dfs(char[] cs, int pos, int ops, int balance, StringBuilder sb) {
        if (pos == cs.length) {
            if (balance == 0 && ops <= min) {
                if (ops < min) {
                    strs.clear();
                    min = ops;
                }

                strs.add(sb.toString());
            }
        } else {
            if (balance < 0) {
                return;
            } else {
                if (cs[pos] == '(' || cs[pos] == ')') {
                    dfs(cs, pos + 1, ops + 1, balance, sb);
                }

                if (cs[pos] == '(') {
                    balance++;
                } else if (cs[pos] == ')') {
                    balance--;
                }

                sb.append(cs[pos]);
                dfs(cs, pos + 1, ops, balance, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        dfs(s.toCharArray(), 0, 0, 0, new StringBuilder());

        return new ArrayList<>(this.strs);
    }
}
// @lc code=end

