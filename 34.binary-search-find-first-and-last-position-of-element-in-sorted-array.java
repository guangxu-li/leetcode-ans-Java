/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    private enum direction {
        left, right;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchBound(nums, 0, target, direction.left);

        if (left == nums.length || nums[left] != target) {
            return new int[] { -1, -1 };
        }

        int right = searchBound(nums, left, target, direction.right);

        return new int[] { left, right - 1 };
    }

    public int searchBound(int[] nums, int start, int target, direction dir) {
        // * direction: true -> left, false -> right
        int lo = start;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] > target || (dir == direction.left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
// @lc code=end
