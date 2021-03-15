import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    private static final Map<Character, Character> pairs = new HashMap<>();

    public Solution() {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    public boolean isValid(String s) {
        Deque<Character> waitToPair = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!pairs.containsKey(c)) {
                waitToPair.push(c);
            } else {
                if (waitToPair.isEmpty() || waitToPair.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }

        return waitToPair.isEmpty();
    }
}
// @lc code=end

