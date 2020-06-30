/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    char[] symbol = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };

    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        int count = 3;
        while (num != 0) {
            int curr = num / (int) Math.pow(10, count);
            num = num - curr * (int) Math.pow(10, count);

            if (curr != 0) {
                convert(str, curr, count);
            }

            count--;
        }

        return str.toString();
    }

    public void convert(StringBuilder str, int x, int count) {
        int base = count * 2;
        if (x == 9) {
            str.append(symbol[base]);
            str.append(symbol[base + 2]);
        } else if (x >= 5) {
            str.append(symbol[base + 1]);
            while (x - 5 != 0) {
                str.append(symbol[base]);
                x--;
            }
        } else if (x == 4) {
            str.append(symbol[base]);
            str.append(symbol[base + 1]);
        } else {
            while (x != 0) {
                str.append(symbol[base]);
                x--;
            }
        }
    }
}
// @lc code=end
