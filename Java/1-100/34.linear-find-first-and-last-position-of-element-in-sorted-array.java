/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (curr == 0) {
                    ans[curr] = i;
                    curr = 1 - curr;
                }

                ans[curr] = i;
            }
        }

        return ans;
    }
}
// @lc code=end
