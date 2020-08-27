import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> blacklist = new HashSet<String>();
        Arrays.stream(banned).forEach(blacklist::add);

        Map<String, Integer> counter = new HashMap<>();
        Arrays.stream(paragraph.toLowerCase().split("[^a-z]"))
                .filter(word -> word.length() > 0 && !blacklist.contains(word)).forEach(word -> {
                    counter.put(word, counter.getOrDefault(word, 0) + 1);
                });

        return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
// @lc code=end

