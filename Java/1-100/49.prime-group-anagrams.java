import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    private int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int key = hashCode(str, primes);

            List<String> list = anagrams.getOrDefault(key, new ArrayList());
            list.add(str);
            anagrams.put(key, list);
        }

        return new ArrayList<>(anagrams.values());
    }

    private int hashCode(String str, int[] primes) {
        int hash = 1;

        for (char c : str.toCharArray()) {
            hash *= primes[c - 'a'];
        }
        return hash;
    }
}
// @lc code=end

