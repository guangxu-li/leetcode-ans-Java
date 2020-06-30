/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[hi] >= nums[0]) {
            return nums[0];
        }

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (nums[mid] >= nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return nums[lo];
    }
}
// @lc code=end
