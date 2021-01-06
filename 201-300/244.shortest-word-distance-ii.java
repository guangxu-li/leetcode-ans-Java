import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=244 lang=java
 *
 * [244] Shortest Word Distance II
 */

// @lc code=start
class WordDistance {
    Map<String, List<Integer>> locs = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            locs.putIfAbsent(words[i], new ArrayList<>());
            locs.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = locs.get(word1);
        List<Integer> loc2 = locs.get(word2);

        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;

        while (p1 < loc1.size() && p2 < loc2.size()) {
            min = Math.min(min, Math.abs(loc1.get(p1) - loc2.get(p2)));

            if (loc1.get(p1) < loc2.get(p2)) {
                p1++;
            } else {
                p2++;
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
// @lc code=end

