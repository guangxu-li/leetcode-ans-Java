import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 */

// @lc code=start
class Solution {
    private int[] getLevel(String s, int i) {
        int level = 0;
        while (i < s.length() && (s.charAt(i) == '\t' || s.charAt(i) == '\n')) {
            level += s.charAt(i++) == '\t' ? 1 : 0;
        }

        return new int[] {level, i};
    }

    private int[] getName(String s, int i) {
        int start = i;
        int cnt = 0;
        while (i < s.length() && s.charAt(i) != '\n') {
            cnt += s.charAt(i++) == '.' ? 1 : 0;
        }

        return new int[] {i - start, cnt};
    }

    public int lengthLongestPath(String input) {
        Deque<Integer> dirs = new ArrayDeque<>();
        int max = 0;

        int i = 0;
        while (i < input.length()) {
            int[] l = getLevel(input, i);
            int level = l[0];
            i = l[1];

            int[] n = getName(input, i);
            int len = n[0];
            i += len;

            while (dirs.size() > level) {
                dirs.pop();
            }

            int nlen = dirs.isEmpty() ? len : dirs.peek() + 1 + len;
            dirs.push(nlen);

            if (n[1] > 0) {
                max = Math.max(max, nlen);
            }
        }

        return max;
    }
}
// @lc code=end

