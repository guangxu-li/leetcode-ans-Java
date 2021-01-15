/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 */

// @lc code=start
class Solution {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void wiggleSort(int[] nums) {
        boolean isAsc = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (isAsc) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }

            isAsc = !isAsc;
        }
    }
}
// @lc code=end

