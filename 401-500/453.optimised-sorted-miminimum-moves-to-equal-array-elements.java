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

        /* each loop is equal to one while loop in sorted method
           diff = nums[n - 1] - nums[0], then nums[n - 2] - nums[0], nums[n -3] - nums[0]...*/
        for (int i = nums.length - 1; i >= 0; i--) {
            count += nums[i] - nums[0];
        }

        return count;
    }
}
// @lc code=end

