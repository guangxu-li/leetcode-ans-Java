/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for (int k = 0; k < nums.length;) {
            if (count[j] == 0) {
                j++;
                continue;
            }

            nums[k++] = j;
            count[j]--;
        }
    }
}
// @lc code=end
