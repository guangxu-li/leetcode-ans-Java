/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int min = getPivot(nums);

        int lo = 0;
        int hi = nums.length - 1;

        if (min == 0 || target < nums[0]) {
            hi = nums.length - 1;
            lo = min;
        } else {
            hi = min - 1;
            lo = 0;
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public int getPivot(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[lo] <= nums[hi]) {
            return 0;
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (nums[mid] >= nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
// @lc code=end
