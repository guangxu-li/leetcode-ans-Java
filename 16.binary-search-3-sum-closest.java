import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 100000;
        Arrays.sort(nums);

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
        int ans = 100000;

        for (int i = start; i < nums.length - 1; i++) {
            int num = target - nums[i];

            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                if (nums[mid] < num) {
                    lo = mid + 1;
                } else if (nums[mid] > num) {
                    hi = mid - 1;
                } else {
                    return nums[i] + nums[mid];
                }

                if (Math.abs(nums[mid] - num) < Math.abs(ans - target)) {
                    ans = nums[i] + nums[mid];
                }
            }
        }

        return ans;
    }
}
// @lc code=end
