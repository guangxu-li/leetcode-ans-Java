/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        for (int i = 0; i <= hi;) {
            switch (nums[i]) {
                case 0:
                    nums[i++] = nums[lo];
                    nums[lo++] = 0;
                    break;
                case 2:
                    nums[i] = nums[hi];
                    nums[hi--] = 2;
                    break;
                default:
                    i++;
                    break;
            }
        }
    }
}
// @lc code=end
