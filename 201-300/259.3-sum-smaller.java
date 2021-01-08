import java.util.Arrays;

/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 */

// @lc code=start
class Solution {
    private int twoSumSmaller(int[] nums, int start, int target) {
        int count = 0;

        int lo = start;
        int hi = nums.length - 1;

        while (lo < hi && nums[lo] <= target / 2) {
            int sum = nums[lo] + nums[hi];

            if (sum < target) {
                count += hi - lo++;
            } else {
                hi--;
            }
        }

        return count;
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length - 2 && nums[i] <= target / 3; i++) {
            int rem = target - nums[i];

            count += twoSumSmaller(nums, i + 1, rem);
        }

        return count;
    }
}
// @lc code=end

