/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    private int[][] states = new int[][] {{0, 1, 2, 3, 8, 8}, {8, 8, 2, 3, 8, 8},
            {8, 8, 2, 3, 5, 8}, {8, 8, 4, 8, 5, 8}, {8, 8, 4, 8, 5, 8}, {8, 6, 7, 8, 8, 8},
            {8, 8, 7, 8, 8, 8}, {8, 8, 7, 8, 8, 8}, {8, 8, 8, 8, 8, 8}};

    public boolean isNumber(String s) {
        s = s.trim();

        int prevState = 0;
        int currState = 0;
        boolean validPoint = true;
        for (int i = 0; i < s.length(); i++) {
            prevState = currState;
            currState = states[prevState][getState(s.charAt(i))];

            if (prevState == 0 && currState == 3) {
                validPoint = false;
            }

            if (prevState == 3 && currState == 5 && !validPoint) {
                return false;
            }

            if (currState == 8) {
                return false;
            }
        }

        if (currState != 2 && (currState != 3 || prevState != 2) && currState != 4
                && currState != 7) {
            return false;
        } else {
            return true;
        }
    }

    private int getState(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        } else if (c == '.') {
            return 3;
        } else if (c == 'e') {
            return 4;
        } else {
            return 5;
        }
    }
}
// @lc code=end

