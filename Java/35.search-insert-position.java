/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {

            /*
             * there's a possibility of (lo + hi) causes overflow in Java
             * int mid = (lo + hi) / 2;
             * int mid = lo + (hi - lo) / 2;
             */
            int mid = (lo + hi) >> 1;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
// @lc code=end
