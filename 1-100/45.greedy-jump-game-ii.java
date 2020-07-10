/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int currStep = nums[0];
        int maxPos = nums[0];
        int ans = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i > currStep) {
                ans++;
                currStep = maxPos;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
        }

        return ans;
    }
}
// @lc code=end

