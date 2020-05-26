/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                ans.append(symbols[i]);
            }
        }

        return ans.toString();
    }
}
// @lc code=end
