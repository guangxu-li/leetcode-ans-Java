import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=1207 lang=java
 *
 * [1207] Unique Number of Occurrences
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int val : arr) {
            cnts.put(val, cnts.getOrDefault(val, 0) + 1);
        }

        return cnts.size() == new HashSet<>(cnts.values()).size();
    }
}
// @lc code=end

