import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> indices = new ArrayDeque<Integer>();

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                indices.push(i);
            } else if (cs[i] == ')') {
                if (!indices.isEmpty() && cs[indices.peek()] == '(') {
                    indices.pop();
                } else {
                    indices.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (indices.isEmpty() || i != indices.peekLast()) {
                sb.append(cs[i]);
            } else {
                indices.poll();
            }
        }

        return sb.toString();
    }
}
// @lc code=end

