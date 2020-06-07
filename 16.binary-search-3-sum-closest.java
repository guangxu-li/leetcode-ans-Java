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
            for (int j = i + 1; j < nums.length - 1; j++) {
                int lo = j + 1;
                int hi = nums.length - 1;

                while (lo <= hi) {
                    int mid = (lo + hi) >> 1;
                    int sum = nums[i] + nums[j] + nums[mid];

                    if (Math.abs(sum - target) < Math.abs(diff)) {
                        diff = sum - target;
                    }

                    if (sum < target) {
                        lo = mid + 1;
                    } else if (sum == target) {
                        break;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
        }

        return diff + target;
    }
}
// @lc code=end
