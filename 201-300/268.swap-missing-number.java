/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[j];
        nums[j] = j;
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }

        int prev = -1;
        for (int num : nums) {
            if (num != prev + 1) {
                return prev + 1;
            }

            prev = num;
        }

        return prev + 1;
    }
}
// @lc code=end

