import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length < 4) {
            return ans;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> threeSum = threeSum(nums, i + 1, target - nums[i]);

            for (List<Integer> l : threeSum) {
                l.add(nums[i]);
                ans.add(l);
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = start; i < nums.length - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> twoSum = twoSum(nums, i + 1, target - nums[i]);

            for (List<Integer> l : twoSum) {
                l.add(nums[i]);
                ans.add(l);
            }
        }

        return ans;
    }

    public List<List<Integer>> twoSum(int nums[], int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        int lo = start;
        int hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];

            if (sum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                lo++;
            } else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                hi--;
            } else {
                ans.add(new ArrayList<Integer>(Arrays.asList(nums[lo], nums[hi])));
                lo++;
                hi--;
            }
        }

        return ans;
    }
}
// @lc code=end
