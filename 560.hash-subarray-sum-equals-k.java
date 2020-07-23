import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        sums.put(0, 1);

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += sums.getOrDefault(sum - k, 0);
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
// @lc code=end

