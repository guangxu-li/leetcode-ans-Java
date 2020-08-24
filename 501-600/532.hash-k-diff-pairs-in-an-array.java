import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Map<Integer, Integer> numCounter = new HashMap<>();
        Arrays.stream(nums).forEach(n -> numCounter.put(n, numCounter.getOrDefault(n, 0) + 1));

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : numCounter.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (numCounter.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
// @lc code=end

