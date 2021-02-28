import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=760 lang=java
 *
 * [760] Find Anagram Mappings
 */

// @lc code=start
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            bMap.put(B[i], i);
        }

        int[] mapping = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            mapping[i] = bMap.get(A[i]);
        }

        return mapping;
    }
}
// @lc code=end

