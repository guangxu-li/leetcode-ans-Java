import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    private List<Integer> subset = new ArrayList<>();
    private List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);

        return subsets;
    }

    private void backtrack(int[] nums, int pos) {

        // add subset generated from previous backtrack
        subsets.add(new ArrayList<>(subset));
        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
// @lc code=end

