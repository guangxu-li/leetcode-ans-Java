/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int len = charArray.length;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < Math.min(len, numRows); i++) {
            int inteval = 2 * numRows - 2 - 2 * i;
            ans.append(charArray[i]);
            for (int j = inteval + i; j < len; j = j + inteval) {
                if (inteval != 0) {
                    ans.append(charArray[j]);
                }

                inteval = 2 * numRows - 2 - inteval;
            }
        }

        return ans.toString();
    }
}
// @lc code=end
