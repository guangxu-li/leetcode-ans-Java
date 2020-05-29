import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    private List<String> ans;
    private int max;

    public Solution() {
        ans = new ArrayList<>();
    }

    public List<String> generateParenthesis(int n) {
        max = n;
        backtrack(new String(), 0, 0);

        return ans;
    }

    public void backtrack(String str, int open, int close) {
        if (str.length() == max * 2) {
            ans.add(str);
            return;
        }

        if (open < max) {
            backtrack(str + '(', open + 1, close);
        }

        if (close < open) {
            backtrack(str + ')', open, close + 1);
        }
    }
}
// @lc code=end
