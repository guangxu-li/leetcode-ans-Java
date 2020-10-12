import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }

        Deque<Integer> nums = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op1 = nums.pop();
                int op2 = nums.pop();

                // op2 " " op1 cause using stack
                if (token.equals("+")) {
                    nums.push(op2 + op1);
                } else if (token.equals("-")) {
                    nums.push(op2 - op1);
                } else if (token.equals("*")) {
                    nums.push(op2 * op1);
                } else {
                    nums.push(op2 / op1);
                }
            } else {
                nums.push(Integer.parseInt(token));
            }
        }

        return nums.peek();
    }
}
// @lc code=end

