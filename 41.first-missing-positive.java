/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        // if there's a 1 in nums
        boolean flag = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                flag = true;
            }
        }

        for (int i : nums) {
            int idx = Math.abs(i);
            if (idx == 1 && flag && nums[idx % nums.length] > 0) {
                nums[idx % nums.length] = -nums[idx % nums.length];
            }

            if (idx != 1 && nums[idx % nums.length] > 0) {
                nums[idx % nums.length] = -nums[idx % nums.length];
            }
        }

        while (ans <= nums.length) {
            if (nums[ans % nums.length] > 0) {
                break;
            }

            ans++;
        }

        return ans;
    }
}
// @lc code=end
