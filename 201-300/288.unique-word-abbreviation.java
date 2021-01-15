import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=288 lang=java
 *
 * [288] Unique Word Abbreviation
 */

// @lc code=start
class ValidWordAbbr {
    private Map<String, Integer> abbrs = new HashMap<>();
    private Set<String> dict;

    public ValidWordAbbr(String[] dictionary) {
        this.dict = new HashSet<>(Arrays.asList(dictionary));

        for (String word : dict) {
            String abbr = getAbbr(word);
            abbrs.put(abbr, abbrs.getOrDefault(abbr, 0) + 1);
        }
    }

    private String getAbbr(String word) {
        return word.length() <= 2 ? word
                : word.charAt(0) + String.valueOf(word.length() - 2)
                        + word.charAt(word.length() - 1);
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !abbrs.containsKey(abbr) || (abbrs.get(abbr) == 1 && dict.contains(word));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
// @lc code=end

