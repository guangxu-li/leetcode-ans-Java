import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
    private long getID(long x, long w) {
        
        // in java, -4/5 = 0, but we need it to be -1
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> buckets = new HashMap<>();
        long w = t + 1;

        for (int i = 0; i < nums.length; i++) {
            long id = getID(nums[i], w);

            if (buckets.containsKey(id)
                    || (buckets.containsKey(id - 1) && Math.abs(nums[i] - buckets.get(id - 1)) <= t)
                            || (buckets.containsKey(id + 1)
                                    && Math.abs(nums[i] - buckets.get(id + 1)) <= t)) {
                return true;
            }

            buckets.put(id, (long) nums[i]);
            if (buckets.size() > k) {
                buckets.remove(getID(nums[i - k], w));
            }
        }

        return false;
    }
}
// @lc code=end

