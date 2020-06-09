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
            char[] chars = str.toCharArray();

            sort(chars);
            String key = String.valueOf(chars);

            List<String> list = anagrams.getOrDefault(key, new ArrayList<>());
            list.add(str);
            anagrams.put(key, list);
        }

        return new ArrayList<>(anagrams.values());
    }

    public void sort(char[] chars) {
        int[] count = new int[26];

        for (char c : chars) {
            count[c - 'a']++;
        }

        int j = 0;

        for (int i = 0; i < chars.length; i++) {
            while (count[j] == 0) {
                j++;
            }

            chars[i] = (char) (j + 'a');

            count[j]--;
        }
    }
}
// @lc code=end

