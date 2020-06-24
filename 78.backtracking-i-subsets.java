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
    private int k = 0;

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            this.k = i;

            backtrack(nums, 0);
        }

        return subsets;
    }

    private void backtrack(int[] nums, int pos) {
        if (subset.size() == k) {
            subsets.add(new ArrayList<>(subset));
        } else {
            for (int i = pos; i < nums.length; i++) {
                subset.add(nums[i]);
                backtrack(nums, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
// @lc code=end

