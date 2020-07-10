/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (hi == nums.length - 1 || (lo <= hi && nums[hi] == nums[hi + 1])) {
            hi--;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (target >= nums[0]) {
                if (nums[mid] >= nums[0] && nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid] < nums[0] && nums[mid] >= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return lo < nums.length && nums[lo] == target;
    }
}
// @lc code=end

