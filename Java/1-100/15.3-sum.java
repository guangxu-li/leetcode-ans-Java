import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= nums.length - 3 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i + 1, res);
            }
        }

        return res;
    }

    public void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i;
        int hi = nums.length - 1;
        int target = nums[i - 1];

        while (lo < hi) {
            int sum = target + nums[lo] + nums[hi];

            if (sum < 0 || (lo > i && nums[lo - 1] == nums[lo])) {
                lo++;
            } else if (sum > 0 || (hi < nums.length - 1) && nums[hi + 1] == nums[hi]) {
                hi--;
            } else {
                res.add(Arrays.asList(target, nums[lo++], nums[hi--]));
            }
        }
    }
}
// @lc code=end
