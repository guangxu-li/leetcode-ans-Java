import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2 && diff != 0; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = sum - target;
                }

                if (sum < target) {
                    lo++;
                } else if (sum == target) {
                    break;
                } else {
                    hi--;
                }
            }
        }

        return diff + target;
    }
}
// @lc code=end
