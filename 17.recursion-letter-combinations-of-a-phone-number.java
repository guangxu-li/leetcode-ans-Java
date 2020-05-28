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

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] t = table[Character.getNumericValue(digits.charAt(0))];

        List<String> next = new ArrayList<>();
        if (digits.length() != 1) {
            next = letterCombinations(digits.substring(1));
        }

        for (int i = 0; i < t.length; i++) {
            String str = new String();
            str += t[i];
            if (digits.length() != 1) {
                for (String s : next) {
                    ans.add(str + s);
                }
            } else {
                ans.add(str);
            }
        }

        return ans;
    }
}
// @lc code=end
