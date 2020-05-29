import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    private Map<Character, Character> map;

    public Solution() {
        map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                if (stack.isEmpty() || stack.pop() != map.get(charArray[i])) {
                    return false;
                }
            } else {
                stack.push(charArray[i]);
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
// @lc code=end
