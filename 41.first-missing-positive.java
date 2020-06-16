/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        boolean flag = false; /* if there's number 1 in the input */

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                flag = true;
            }
        }

        for (int num : nums) {
            int idx = Math.abs(num);
            if ((idx != 1 || flag) && nums[idx % nums.length] > 0) {
                nums[idx % nums.length] = -nums[idx % nums.length];
            }
        }

        while (ans <= nums.length && nums[ans % nums.length] <= 0) {
            ans++;
        }

        return ans;
    }
}
// @lc code=end
