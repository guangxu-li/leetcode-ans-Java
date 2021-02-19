import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixs = new HashMap<>();
        prefixs.put(0, -1);
        int cnt = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] == 0 ? -1 : 1;
            if (prefixs.containsKey(cnt)) {
                len = Math.max(len, i - prefixs.get(cnt)); 
            } else {
                prefixs.put(cnt, i);
            }
        }

        return len;
    }
}
// @lc code=end

