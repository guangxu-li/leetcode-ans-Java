import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<Character, List<Character>>();
        Map<Character, Integer> counts = new HashMap<Character, Integer>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new ArrayList<Character>());
                counts.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    counts.put(c2, counts.get(c2) + 1);

                    break;
                }
            }
        }

        Queue<Character> cs = new LinkedList<Character>();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 0) {
                cs.add(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!cs.isEmpty()) {
            char c = cs.poll();
            sb.append(c);

            for (char ch : adj.get(c)) {
                int count = counts.get(ch);
                counts.put(ch, count - 1);
                if (count == 1) {
                    cs.add(ch);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }

        return sb.toString();
    }
}
// @lc code=end

