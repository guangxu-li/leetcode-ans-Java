/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        // 0: start + " " -> 0, + "+" / "-" -> 1, +number -> 2, +other -> end
        // 1: signed + number -> 2, else -> end
        // 2: number + number -> 2, else -> end
        // 3: end
        int[][] state = new int[][] { { 0, 1, 2, 3 }, { 3, 3, 2, 3 }, { 3, 3, 2, 3 }, { 3, 3, 3, 3 } };
        int curr = 0;
        int sign = 1;

        char[] charArray = str.toCharArray();
        int ans = 0;

        for (int i = 0; i < charArray.length; i++) {
            curr = state[curr][getState(charArray[i])];
            if (curr == 1) {
                sign = charArray[i] == '+' ? 1 : -1;
            } else if (curr == 2) {
                int tmp = sign * Character.getNumericValue(charArray[i]);
                if (outOfBound(ans, tmp)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans * 10 + tmp;
            } else if (curr == 3) {
                break;
            }
        }

        return ans;
    }

    public int getState(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        } else {
            return 3;
        }
    }

    public boolean outOfBound(int ans, int tmp) {
        if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tmp > 7)) {
            return true;
        }

        if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tmp < -8)) {
            return true;
        }

        return false;
    }
}
// @lc code=end
