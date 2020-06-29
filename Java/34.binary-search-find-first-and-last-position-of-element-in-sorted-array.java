/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeftBound(nums, 0, target);

        if (left == nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }

        int right = searchRightBound(nums, left, target);

        return new int[] {left, right};
    }

    public int searchLeftBound(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    public int searchRightBound(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
// @lc code=end
