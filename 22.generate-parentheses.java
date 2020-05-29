import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    private List[] cache;

    public List<String> generateParenthesis(int n) {
        if (cache == null) {
            cache = new ArrayList[n + 1];
        }

        if (cache[n] != null) {
            return cache[n];
        }

        List<String> ans = new ArrayList<>();

        if (n == 0) {
            ans.add("");
        } else if (n == 1) {
            ans.add("()");
        } else {
            for (int i = 0; i < n; i++) {
                for (String l : generateParenthesis(i)) {
                    for (String r : generateParenthesis(n - i - 1)) {
                        ans.add('(' + l + ')' + r);
                    }
                }
            }
        }

        cache[n] = ans;
        return ans;
    }
}
// @lc code=end
