import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    private static String[][] table =
            {null, null, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
                    {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            backtrack("", digits, 0);
        }

        return ans;
    }

    public void backtrack(String combination, String digits, int pos) {
        if (digits.length() == pos) {
            ans.add(combination);
        } else {
            String[] t = table[Character.getNumericValue(digits.charAt(pos))];

            for (String s : t) {
                backtrack(combination + s, digits, pos + 1);
            }
        }
    }
}
// @lc code=end
