import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    static String[] t2 = { "a", "b", "c" };
    static String[] t3 = { "d", "e", "f" };
    static String[] t4 = { "g", "h", "i" };
    static String[] t5 = { "j", "k", "l" };
    static String[] t6 = { "m", "n", "o" };
    static String[] t7 = { "p", "q", "r", "s" };
    static String[] t8 = { "t", "u", "v" };
    static String[] t9 = { "w", "x", "y", "z" };

    static String[][] table = { null, null, t2, t3, t4, t5, t6, t7, t8, t9 };

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }

        return ans;
    }

    public void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            ans.add(combination);
        } else {
            String[] t = table[Character.getNumericValue(digits.charAt(0))];

            for (String str : t) {
                backtrack(combination + str, digits.substring(1));
            }
        }
    }
}
// @lc code=end
