/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num1.charAt(0) == '0') {
            return num2;
        } else if (num2.length() == 0 || num2.charAt(0) == '0') {
            return num1;
        }

        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();

        char[] sum = new char[Math.max(cs1.length, cs2.length) + 1];

        for (int i = 1; i <= Math.max(cs1.length, cs2.length); i++) {
            int indice1 = cs1.length - i;
            int indice2 = cs2.length - i;
            int sumIndice = sum.length - i;

            int x = indice1 < 0 ? 0 : cs1[indice1] - '0';
            int y = indice2 < 0 ? 0 : cs2[indice2] - '0';
            int carry = sum[sumIndice] == 0 ? 0 : sum[sumIndice] - '0';

            int num = carry + x + y;
            sum[sumIndice] = (char) (num % 10 + (int) '0');
            sum[sumIndice - 1] = (char) (num / 10 + (int) '0');
        }

        if (sum[0] == '0') {
            return String.valueOf(sum, 1, sum.length - 1);
        } else {
            return String.valueOf(sum, 0, sum.length);
        }
    }
}
// @lc code=end

