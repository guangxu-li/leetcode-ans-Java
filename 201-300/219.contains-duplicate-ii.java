import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numbers = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }

            numbers.add(nums[i]);
            if (numbers.size() > k) {
                numbers.remove(nums[i - k]);
            }
        }

        return false;
    }
}
// @lc code=end

