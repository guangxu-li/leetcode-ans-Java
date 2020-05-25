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

        StringBuilder[] rows = new StringBuilder[Math.min(s.length(), numRows)];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        char[] charArray = s.toCharArray();
        int dir = -1; // 1 -> down, -1 -> up
        for (int i = 0, j = 0; i < charArray.length; i++, j += dir) {
            rows[j].append(charArray[i]);

            if (j == 0 || j == numRows - 1) {
                dir = -dir;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }

        return ans.toString();
    }
}
// @lc code=end
