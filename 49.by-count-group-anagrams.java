import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            char[] chars = new char[26];
            for (int i = 0; i < 26; i++) {
                chars[i] = (char) (count[i] + 'a');
            }

            String key = String.valueOf(chars);
            List<String> list = anagrams.getOrDefault(key, new ArrayList<>());
            list.add(str);
            anagrams.put(key, list);
        }

        return new ArrayList(anagrams.values());
    }
}
// @lc code=end

