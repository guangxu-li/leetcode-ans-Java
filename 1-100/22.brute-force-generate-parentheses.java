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

    public Solution() {
        ans = new ArrayList<>();
    }

    public List<String> generateParenthesis(int n) {
        generate(new char[2 * n], 0);

        return ans;
    }

    public void generate(char[] curr, int pos) {
        if (pos == curr.length) {
            if (valid(curr)) {
                ans.add(new String(curr));
            }
        } else {
            curr[pos] = '(';
            generate(curr, pos + 1);
            curr[pos] = ')';
            generate(curr, pos + 1);
        }
    }

    public boolean valid(char[] curr) {
        int balance = 0;
        for (char c : curr) {
            if (c == '(') {
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
