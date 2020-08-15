import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    private boolean isOp(char[] cs, int pos) {
        char c = cs[pos];

        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int calculate(String s) {
        char[] cs = s.replaceAll(" ", "").toCharArray();

        Deque<Integer> nums = new ArrayDeque<>();
        int i = 0;

        while (i < cs.length) {
            int num = 0;
            char op = '+';

            if (isOp(cs, i)) {
                op = cs[i++];
            }

            while (i < s.length() && Character.isDigit(cs[i])) {
                num = num * 10 + cs[i++] - '0';
            }

            if (op == '+') {
                nums.push(num);
            } else if (op == '-') {
                nums.push(-num);
            } else if (op == '*') {
                nums.push(nums.pop() * num);
            } else {
                nums.push(nums.pop() / num);
            }
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }

        return res;
    }
}
// @lc code=end

