import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    private int[] parentheses;

    private String decodeCharArray(char[] cs, int start, int end) {
        StringBuilder sb = new StringBuilder();

        int k = 0;
        int i = start;
        while (i <= end) {
            if (Character.isDigit(cs[i])) {
                k = 10 * k + cs[i] - '0';
            } else if (cs[i] == '[') {
                String str = decodeCharArray(cs, i + 1, parentheses[i] - 1);

                while (k-- > 0) {
                    sb.append(str);
                }

                k = 0;
                i = parentheses[i];
            } else {
                sb.append(cs[i]);
            }

            i++;
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        parentheses = new int[s.length()];

        Deque<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length; i++) {
            char c = s.charAt(i);

            if (c == '[' || c == ']') {
                if (c == '[') {
                    indices.push(i);
                } else {
                    parentheses[indices.pop()] = i;
                }
            }
        }

        return decodeCharArray(s.toCharArray(), 0, s.length() - 1);
    }
}
// @lc code=end

