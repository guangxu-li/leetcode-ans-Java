import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set =
                Arrays.stream(words).filter(s -> s.length() > 0).collect(Collectors.toSet());
        return Arrays.stream(words).filter(s -> isValid(set, s, 0)).collect(Collectors.toList());
    }

    private boolean isValid(Set<String> set, String word, int start) {
        for (int i = start; i <= word.length(); i++) {
            if (set.contains(word.substring(start, i))
                    && (set.contains(word.substring(i)) || isValid(set, word, i))) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

