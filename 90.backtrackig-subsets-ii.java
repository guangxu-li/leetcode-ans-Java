import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> subsets = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        backtrack(nums, 0);

        return subsets;
    }

    private void backtrack(int[] nums, int pos) {

        // add subset generated from previous backtrack
        subsets.add(new ArrayList<>(subset));

        for (int i = pos; i < nums.length; i++) {
            if (i == pos || nums[i] != nums[i - 1]) {
                subset.add(nums[i]);
                backtrack(nums, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
// @lc code=end

