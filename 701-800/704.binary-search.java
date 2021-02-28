/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
// @lc code=end

