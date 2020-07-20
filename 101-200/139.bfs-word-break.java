import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> heads = new ArrayDeque<Integer>();

        int[] visited = new int[s.length()];
        heads.add(0);

        while (!heads.isEmpty()) {
            int start = heads.poll();

            if (visited[start] == 0) {
                for (String word : wordDict) {
                    if (s.startsWith(word, start)) {
                        int end = start + word.length();
                        if (end == s.length()) {
                            return true;
                        }

                        heads.add(end);
                    }
                }

                visited[start] = 1;
            }
        }

        return false;
    }
}
// @lc code=end

