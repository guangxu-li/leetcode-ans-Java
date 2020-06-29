/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[start] = nums[i];
                start++;
            }
        }

        return start;
    }
}
// @lc code=end
