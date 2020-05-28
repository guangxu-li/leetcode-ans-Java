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

        int ans = 100000;

        for (int i = 0; i < nums.length - 2; i++) {
            int num = target - nums[i];
            int sum = nums[i] + twoSumClosest(nums, i + 1, num);
            if (Math.abs(sum - target) < Math.abs(ans - target)) {
                ans = sum;
            }
        }

        return ans;
    }

    public int twoSumClosest(int[] nums, int start, int target) {

        int lo = start;
        int hi = nums.length - 1;

        int ans = 100000;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];

            if (sum == target) {
                return sum;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }

            if (Math.abs(sum - target) < Math.abs(ans - target)) {
                ans = sum;
            }
        }

        return ans;
    }
}
// @lc code=end
