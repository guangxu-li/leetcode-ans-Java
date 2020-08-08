import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> ops = new ArrayDeque<>();

        int op = 0;
        int res = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                op = 10 * op + c - '0';
            } else if (c == '+') {
                res += sign * op;
                sign = 1;
                op = 0;
            } else if (c == '-') {
                res += sign * op;
                sign = -1;
                op = 0;
            } else if (c == '(') {
                ops.push(res);
                ops.push(sign);

                res = 0;
                sign = 1;
            } else {
                res += sign * op;
                res = res * ops.pop() + ops.pop();
            }
        }

        return res + sign * op;
    }
}
// @lc code=end

