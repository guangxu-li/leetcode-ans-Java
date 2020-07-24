import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
    private Map<Character, List<Character>> reversedAdj = new HashMap<Character, List<Character>>();
    private Integer[] visited;
    private StringBuilder sb = new StringBuilder();

    private int dfs(char c) {
        if (visited[c - 'a'] != null) {
            return visited[c - 'a'];
        }

        visited[c - 'a'] = 0;
        for (char ch : reversedAdj.get(c)) {
            if (dfs(ch) == 0) {
                return 0;
            }
        }
        visited[c - 'a'] = 1;

        sb.append(c);

        return 1;
    }

    public String alienOrder(String[] words) {
        this.visited = new Integer[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                reversedAdj.putIfAbsent(c, new ArrayList<Character>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    reversedAdj.get(c2).add(c1);

                    break;
                }
            }
        }

        for (char c : reversedAdj.keySet()) {
            if (dfs(c) == 0) {
                return "";
            }
        }

        if (sb.length() < reversedAdj.size()) {
            return "";
        }

        return sb.toString();
    }
}
// @lc code=end

