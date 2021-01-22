import java.util.Arrays;

/*
 * @lc app=leetcode id=453 lang=java
 *
 * [453] Minimum Moves to Equal Array Elements
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        int min = 0;
        int max = nums.length - 1;

        while (min < max) {
            if (nums[min] == nums[max]) {
                break;
            }

            int diff = nums[max] - nums[min];
            count += diff;

            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i] += diff;
                }
            }

            max--;
        }

        return count;
    }
}
// @lc code=end

