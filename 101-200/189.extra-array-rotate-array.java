/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int left = 0;
        int right = nums.length - k % nums.length;

        int[] res = nums.clone();
        int i = 0;

        while (right < nums.length) {
            nums[i] = res[right++];
            i++;
        }

        while (i < res.length) {
            nums[i] = res[left++];
            i++;
        }
    }
}
// @lc code=end

