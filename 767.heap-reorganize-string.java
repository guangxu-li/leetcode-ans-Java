import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }

        Queue<Character> cs =
                new PriorityQueue<>((a, b) -> a == b ? a - b : count[b - 'a'] - count[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (count[i] > (S.length() + 1) / 2) {
                return "";
            }

            if (count[i] > 0) {
                cs.add((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (cs.size() > 1) {
            char a = cs.poll();
            char b = cs.poll();

            sb.append(a);
            sb.append(b);

            if (--count[a - 'a'] > 0) {
                cs.add(a);
            }

            if (--count[b - 'a'] > 0) {
                cs.add(b);
            }
        }

        if (!cs.isEmpty()) {
            sb.append(cs.poll());
        }

        return sb.toString();
    }
}
// @lc code=end

