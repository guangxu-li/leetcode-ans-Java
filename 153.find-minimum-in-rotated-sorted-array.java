/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int lo = 0;
        int hi = nums.length - 1;

        if (nums[hi] >= nums[0]) {
            return nums[0];
        }

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            // * mid = 0 => lo = 0, hi = 1;
            // * code line -8 to -6 has dealed with the case [1, 2]
            // * to avoid index overflow, deal with nums[mid] > nums[mid + 1] first;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
// @lc code=end
