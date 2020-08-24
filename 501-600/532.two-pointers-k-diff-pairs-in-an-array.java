import java.util.Arrays;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;

        int lo = 0;
        int hi = 0;
        while (lo < nums.length && hi < nums.length) {
            int distance = nums[hi] - nums[lo];
            if (lo == hi || distance < k) {
                hi++;
            } else if (distance > k) {
                lo++;
            } else {
                count++;

                int cur = nums[lo];
                while (lo < nums.length && nums[lo] == cur) {
                    lo++;
                }
            }
        }

        return count;
    }
}
// @lc code=end

