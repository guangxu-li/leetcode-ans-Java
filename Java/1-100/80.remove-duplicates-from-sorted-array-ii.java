/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int curr = 0;
        int lo = 0;
        int hi = 0;

        while (hi < nums.length) {
            if (curr != nums[hi]) {
                count = 1;
                curr = nums[hi];
                nums[lo++] = nums[hi++];
            } else if (count < 2) {
                count++;
                nums[lo++] = nums[hi++];
            } else {
                while (hi < nums.length && nums[hi] == curr) {
                    hi++;
                }
            }
        }

        return lo;
    }
}
// @lc code=end

