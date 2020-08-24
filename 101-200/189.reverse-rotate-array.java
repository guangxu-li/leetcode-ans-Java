/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int tmp = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = tmp;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
// @lc code=end

